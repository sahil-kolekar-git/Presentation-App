package com.ty.presentationapp.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ty.presentationapp.enums.Role;
import com.ty.presentationapp.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_info")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String name;

	@Column(unique = true)
	private String email;

	private Long phone;

	private String password;

	private Double userTotalScore;

	@Enumerated(EnumType.STRING)
	private Role role;

	@OneToMany(mappedBy = "user")
	private List<Presentation> presentation;

	@Enumerated(EnumType.STRING)
	private Status status = Status.ACTIVE;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime dateTime;

	@UpdateTimestamp
	private LocalDateTime updateDateTime;

}
