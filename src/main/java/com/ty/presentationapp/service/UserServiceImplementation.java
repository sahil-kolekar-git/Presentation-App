package com.ty.presentationapp.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.presentationapp.dto.UserDTO;
import com.ty.presentationapp.dto.UserLoginDTO;
import com.ty.presentationapp.dto.UserResponseDTO;
import com.ty.presentationapp.entity.User;
import com.ty.presentationapp.enums.Role;
import com.ty.presentationapp.exception.DuplicateEmailException;
import com.ty.presentationapp.exception.NotAdminException;
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

	@Override
	public UserResponseDTO getUserDetails(Integer id) {

		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not registred"));

		UserResponseDTO dto = new UserResponseDTO();
		BeanUtils.copyProperties(user, dto);

		return dto;
	}

	@Override
	public List<UserResponseDTO> getAll(Integer id) {

		User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not registred"));

		if (user.getRole().equals(Role.ADMIN)) {

			List<User> users = userRepository.findAll();
			List<UserResponseDTO> list = new LinkedList<>();

			for (User u : users) {
				UserResponseDTO u1 = new UserResponseDTO();
				BeanUtils.copyProperties(u, u1);
				list.add(u1);
			}

			return list;
		}

		throw new NotAdminException("Not an admin");
	}
	
	
	

}
