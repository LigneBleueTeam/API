package com.ligne.bleue.uphf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligne.bleue.uphf.models.Activity;
import com.ligne.bleue.uphf.repositories.ActivityRepository;

@Service
public class ActivityService {
	
	@Autowired
	ActivityRepository activityRepo;
	
	/**
	 * Get all activities
	 * **/
	public List<Activity> getAllActivities() {
		return activityRepo.findAll();
	}
	
	/**
	 * Get an activity by ID
	 * **/
	public Activity getActivity(Long id) {
		return activityRepo.findById(id).get();
	}
	
	/**
	 * Save an activity
	 * **/
	public Activity saveActivity(Activity a) {
		return activityRepo.save(a);
	}
}
