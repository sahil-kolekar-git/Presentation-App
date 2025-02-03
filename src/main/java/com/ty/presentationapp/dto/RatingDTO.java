package com.ty.presentationapp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RatingDTO {

	private Integer communication;

	private Integer confidence;

	private Integer interaction;

	private Integer liveliness;

	private Integer usageProps;
}
