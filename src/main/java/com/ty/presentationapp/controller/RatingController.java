package com.ty.presentationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.presentationapp.dto.RatingDTO;
import com.ty.presentationapp.entity.Rating;
import com.ty.presentationapp.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping("/rate/{sid}/{pid}")
	public ResponseEntity<Rating> postMethodName(@PathVariable Integer sid, @PathVariable Integer pid,
			@RequestBody RatingDTO rating) {

		Rating rate = ratingService.rate(sid, pid, rating);

		return new ResponseEntity<Rating>(rate, HttpStatus.OK);
	}

}
