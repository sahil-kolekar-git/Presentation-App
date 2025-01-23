package com.ty.presentationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.presentationapp.dto.UserDTO;
import com.ty.presentationapp.dto.UserLoginDTO;
import com.ty.presentationapp.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {

		boolean registred = userService.registerUser(userDTO);

		if (registred)
			return ResponseEntity.ok("Registred Successfully");
		return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_GATEWAY);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserLoginDTO userLoginDTO) {

		boolean loggedIn = userService.loginUser(userLoginDTO);

		if (loggedIn)
			return ResponseEntity.ok("Logged In...");
		return new ResponseEntity<String>("Wrong Credentials", HttpStatus.BAD_REQUEST);

	}

}
