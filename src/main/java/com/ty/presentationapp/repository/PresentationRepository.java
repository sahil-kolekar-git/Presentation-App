package com.ty.presentationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ty.presentationapp.entity.Presentation;

@Repository
public interface PresentationRepository extends JpaRepository<Presentation, Integer> {

}
