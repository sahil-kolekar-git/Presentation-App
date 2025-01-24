package com.ty.presentationapp.dto;

import com.ty.presentationapp.enums.Role;
import com.ty.presentationapp.enums.Status;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDTO {

	private String name;

	private String email;

	private Long phone;

	private Double userTotalScore;

	private Role role;

	private Status status = Status.ACTIVE;
}
