package com.ty.presentationapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.presentationapp.entity.Presentation;
import com.ty.presentationapp.enums.PresentationStatus;
import com.ty.presentationapp.service.PresentationService;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@RestController
@RequestMapping("/presentation")
public class PresentationController {

	@Autowired
	private PresentationService presentationService;

	@PostMapping("/assign")
	public ResponseEntity<String> assignPresentation(@RequestParam Integer id, @RequestBody Presentation presentation) {

		boolean assigned = presentationService.assign(id, presentation);

		if (assigned) {
			return new ResponseEntity<String>("Presentation is assigned", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Something went wrong ", HttpStatus.BAD_GATEWAY);
		}

	}

	@PostMapping("/updateStatus")
	public ResponseEntity<Presentation> updateStatus(@RequestParam Integer id,
			@RequestParam PresentationStatus status) {

		Presentation updated = presentationService.updateStatus(id, status);
		return new ResponseEntity<Presentation>(updated, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<Presentation> getPresentation(@RequestParam Integer id) {

		Presentation pres = presentationService.getPresentationById(id);
		return new ResponseEntity<Presentation>(pres, HttpStatus.OK);
	}

	@GetMapping("/getall/{id}")
	public ResponseEntity<List<Presentation>> getMethodName(@PathVariable Integer id) {

		List<Presentation> list = presentationService.getAllPresentations(id);

		return new ResponseEntity<List<Presentation>>(list, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<List<Presentation>> updateScore(@RequestParam Integer id) {

		List<Presentation> list = presentationService.updateScore(id);
		return new ResponseEntity<List<Presentation>>(list, HttpStatus.OK);
	}

}
