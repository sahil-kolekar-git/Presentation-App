package com.ty.presentationapp.service;

import com.ty.presentationapp.dto.RatingDTO;
import com.ty.presentationapp.entity.Rating;

public interface RatingService {

	Rating rate(Integer sid, Integer pid, RatingDTO rating);


}
