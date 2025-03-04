package com.ty.presentationapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.presentationapp.dto.UserDTO;
import com.ty.presentationapp.dto.UserLoginDTO;
import com.ty.presentationapp.dto.UserResponseDTO;
import com.ty.presentationapp.enums.Status;
import com.ty.presentationapp.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;

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

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getDetails(@PathVariable Integer id) {

		UserResponseDTO userRespDTO = userService.getUserDetails(id);

		if (userRespDTO.getStatus().equals(Status.ACTIVE))
			return new ResponseEntity<UserResponseDTO>(userRespDTO, HttpStatus.OK);
		return new ResponseEntity<String>("User is not active", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/getall/{id}")
	public ResponseEntity<List<UserResponseDTO>> getMethodName(@PathVariable Integer id) {
		List<UserResponseDTO> users = userService.getAll(id);

		return new ResponseEntity<List<UserResponseDTO>>(users, HttpStatus.OK);
	}

	@PutMapping("/updatestatus/{id}/{uid}")
	public ResponseEntity<UserResponseDTO> putMethodName(@PathVariable Integer id, @PathVariable Integer uid) {

		UserResponseDTO user = userService.updateStatus(id, uid);
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		boolean deleted = userService.delete(id);
		if (deleted)
			return new ResponseEntity<>("User deleted", HttpStatus.OK);
		return new ResponseEntity<String>("Something went wrong", HttpStatus.BAD_REQUEST);

	}

}
