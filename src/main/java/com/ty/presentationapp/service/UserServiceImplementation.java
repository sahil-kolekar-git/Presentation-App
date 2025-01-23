package com.ty.presentationapp.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.presentationapp.dto.UserDTO;
import com.ty.presentationapp.dto.UserLoginDTO;
import com.ty.presentationapp.entity.User;
import com.ty.presentationapp.exception.DuplicateEmailException;
import com.ty.presentationapp.exception.UserNotFoundException;
import com.ty.presentationapp.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean registerUser(UserDTO userDTO) {

		System.out.println(userDTO.getEmail());
		Optional<User> opt = userRepository.findByEmail(userDTO.getEmail());

		if (opt.isPresent())
			throw new DuplicateEmailException("User Already Registred");
		else {
			User user = new User();
			BeanUtils.copyProperties(userDTO, user);
			return userRepository.save(user) != null;
		}

	}

	@Override
	public boolean loginUser(UserLoginDTO userLoginDTO) {

		User user = userRepository.findByEmail(userLoginDTO.getEmail())
				.orElseThrow(() -> new UserNotFoundException("User Not Registred"));

		if (user.getPassword().equals(userLoginDTO.getPassword()))
			return true;
		return false;
	}
}
