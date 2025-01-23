package com.ty.presentationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.presentationapp.service.PresentationService;

@RestController
@RequestMapping("/presentation")
public class PresentationController {

	@Autowired
	private PresentationService presentationService;
}
