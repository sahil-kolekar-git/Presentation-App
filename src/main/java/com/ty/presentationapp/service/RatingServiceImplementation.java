package com.ty.presentationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.presentationapp.repository.RatingRepository;

@Service
public class RatingServiceImplementation implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
}
