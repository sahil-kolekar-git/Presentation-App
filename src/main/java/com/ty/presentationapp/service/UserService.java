package com.ty.presentationapp.service;

import com.ty.presentationapp.dto.UserDTO;
import com.ty.presentationapp.dto.UserLoginDTO;

public interface UserService {

	boolean registerUser(UserDTO userDTO);

	boolean loginUser(UserLoginDTO userLoginDTO);

}
