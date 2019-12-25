package com.ligne.bleue.uphf.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ligne.bleue.uphf.models.Activity;
import com.ligne.bleue.uphf.services.ActivityService;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {

	@Autowired
	ActivityService activityService;

	/**
	 * Get an activity by ID
	 **/
	@GetMapping("/{id}")
	public ResponseEntity<Activity> getActivity(@PathVariable(value = "id") Long id) {
		Activity a = activityService.getActivity(id);
		if (a == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(a);
		}
	}

	/**
	 * Get all activities
	 **/
	@GetMapping("/all")
	public List<Activity> getAllActivities() {
		return activityService.getAllActivities();
	}

	/**
	 * Create a new activity
	 **/
	@PostMapping("/save")
	public Activity createActivity(@Valid @RequestBody Activity a) {
		return activityService.saveActivity(a);
	}

	/**
	 * Update an activity
	 **/
	@PutMapping("/{id}")
	public ResponseEntity<Activity> updateActivity(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Activity activityDetails) {
		Activity a = activityService.getActivity(id);

		if (a == null) {
			return ResponseEntity.notFound().build();
		} else {
			if (activityDetails.getLevel() != 0) {
				a.setLevel(activityDetails.getLevel());
			}
			if (activityDetails.getLocation() != null) {
				a.setLocation(activityDetails.getLocation());
			}
			if (activityDetails.getName() != null) {
				a.setName(activityDetails.getName());
			}
			if (activityDetails.getTime() != null) {
				a.setTime(activityDetails.getTime());
			}
			if (activityDetails.getType() != null) {
				a.setType(activityDetails.getType());
			}
		}

		Activity updatedActivity = activityService.saveActivity(a);
		return ResponseEntity.ok().body(updatedActivity);
	}
}
