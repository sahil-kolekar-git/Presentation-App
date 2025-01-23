package com.ty.presentationapp.dto;

import com.ty.presentationapp.enums.Role;
import com.ty.presentationapp.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	private String name;

	private String email;

	private Long phone;

	private String password;

	private Double userTotalScore;

	private Role role;

	private Status status = Status.ACTIVE;
}
