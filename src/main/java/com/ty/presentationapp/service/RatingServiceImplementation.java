package com.ty.presentationapp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.presentationapp.dto.RatingDTO;
import com.ty.presentationapp.entity.Presentation;
import com.ty.presentationapp.entity.Rating;
import com.ty.presentationapp.entity.User;
import com.ty.presentationapp.exception.PresentationNotFoundException;
import com.ty.presentationapp.exception.UserNotFoundException;
import com.ty.presentationapp.repository.PresentationRepository;
import com.ty.presentationapp.repository.RatingRepository;
import com.ty.presentationapp.repository.UserRepository;

@Service
public class RatingServiceImplementation implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PresentationRepository presentationRepository;

	@Override
	public Rating rate(Integer sid, Integer pid, RatingDTO rating) {

		User user = userRepository.findById(sid).orElseThrow(() -> new UserNotFoundException("Student not found"));

		Presentation presentation = presentationRepository.findById(pid)
				.orElseThrow(() -> new PresentationNotFoundException("Presentation not found"));

		Rating rate = new Rating();
		rate.setUser(user);
		rate.setPresentation(presentation);
		Double total = 0.0;
		total = (double) ((rating.getCommunication() + rating.getConfidence() + rating.getInteraction()
				+ rating.getLiveliness() + rating.getUsageProps()) / 5);
		rate.setTotalScore(total);

		BeanUtils.copyProperties(rating, rate);

		presentation.setUserTotalScore(rate.getTotalScore());

		presentationRepository.save(presentation);

		Rating saved = ratingRepository.save(rate);

		return saved;
	}

}
