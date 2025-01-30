package com.ty.presentationapp.service;

import java.util.Optional;

import com.ty.presentationapp.entity.Presentation;
import com.ty.presentationapp.enums.PresentationStatus;
import com.ty.presentationapp.enums.Status;

public interface PresentationService {

	boolean assign(Integer id, Presentation presentation);

	Presentation updateStatus(Integer id, PresentationStatus status);

	Presentation getPresentationById(Integer id);

}
