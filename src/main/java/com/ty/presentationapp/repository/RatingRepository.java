package com.ty.presentationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.presentationapp.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
