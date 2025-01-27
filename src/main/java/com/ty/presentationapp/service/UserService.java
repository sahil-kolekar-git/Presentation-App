package com.ty.presentationapp.service;

import java.util.List;

import com.ty.presentationapp.dto.UserDTO;
import com.ty.presentationapp.dto.UserLoginDTO;
import com.ty.presentationapp.dto.UserResponseDTO;
import com.ty.presentationapp.entity.User;

public interface UserService {

	boolean registerUser(UserDTO userDTO);

	boolean loginUser(UserLoginDTO userLoginDTO);

	UserResponseDTO getUserDetails(Integer id);

	List<UserResponseDTO> getAll(Integer id);

	UserResponseDTO updateStatus(Integer id, Integer uid);

	boolean delete(Integer id);

}
