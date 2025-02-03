package com.ty.presentationapp.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.authenticator.DigestAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.presentationapp.entity.Presentation;
import com.ty.presentationapp.entity.User;
import com.ty.presentationapp.enums.PresentationStatus;
import com.ty.presentationapp.enums.Role;
import com.ty.presentationapp.enums.Status;
import com.ty.presentationapp.exception.InvailidOperationException;
import com.ty.presentationapp.exception.PresentationNotFoundException;
import com.ty.presentationapp.exception.UserNotFoundException;
import com.ty.presentationapp.repository.PresentationRepository;
import com.ty.presentationapp.repository.UserRepository;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Service
public class PresentationServiceImplementation implements PresentationService {

	@Autowired
	private PresentationRepository presentationRepository;

	@Autowired
	private UserRepository repository;

	@Override
	public boolean assign(Integer id, Presentation presentation) {

		User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("Student not registred"));

		presentation.setUser(user);
		if (user.getRole().equals(Role.STUDENT)) {
			presentation.setUser(user);
			Presentation presentation1 = presentationRepository.save(presentation);

			return presentation1 != null;
		} else {
			throw new InvailidOperationException("Cannot assign presentation to ADMIN");
		}

	}

	@Override
	public Presentation updateStatus(Integer id, PresentationStatus status) {

		System.out.println(status);
		Presentation presentation = presentationRepository.findById(id)
				.orElseThrow(() -> new PresentationNotFoundException("Presention not assigned"));

		presentation.setPresentationstatus(status);

		Presentation updated = presentationRepository.save(presentation);

		return updated;
	}

	@Override
	public Presentation getPresentationById(Integer id) {

		Presentation pres = presentationRepository.findById(id)
				.orElseThrow(() -> new PresentationNotFoundException("Presentation not assgined"));
		return pres;
	}

	@Override
	public List<Presentation> getAllPresentations(Integer id) {
		User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("Student not found"));

		List<Presentation> presentation = user.getPresentation();
		return presentation;
	}

	@Override
	public List<Presentation> updateScore(Integer id) {

		User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("Student not found"));
		List<Presentation> presentation = user.getPresentation();

		Double total = 0.0;
		for (Presentation pre : presentation) {
			total += pre.getUserTotalScore();
		}

		user.setUserTotalScore(total);
		repository.save(user);
		return presentation;
	}
	
	
}
