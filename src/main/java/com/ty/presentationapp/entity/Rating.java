package com.ty.presentationapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "rating_info")
@Data
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer rid;

	private Integer communication;

	private Integer confidence;

	private Integer interaction;

	private Integer liveliness;

	private Integer usageProps;

	private Double totalScore;

	@ManyToOne
	private User user;

	@ManyToOne
	private Presentation presentation;

}
