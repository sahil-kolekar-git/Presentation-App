package com.ty.presentationapp.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ty.presentationapp.enums.PresentationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "presentation_details")
@Data
public class Presentation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer pid;

	private String course;

	private String topic;

	@Enumerated(EnumType.STRING)
	private PresentationStatus presentationstatus;

	private Double userTotalScore;

	@ManyToOne
	@JoinColumn
	private User user;

	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime dateTime;

	@UpdateTimestamp
	private LocalDateTime updateDateTime;

}
