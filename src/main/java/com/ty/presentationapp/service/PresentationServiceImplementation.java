package com.ty.presentationapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.presentationapp.repository.PresentationRepository;

@Service
public class PresentationServiceImplementation implements PresentationService {

	@Autowired
	private PresentationRepository presentationRepository;
}
