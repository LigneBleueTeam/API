package com.ligne.bleue.uphf.controllers;

import java.util.Date;
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

import com.ligne.bleue.uphf.exeptions.ActivityNotFoundException;
import com.ligne.bleue.uphf.exeptions.EmptyFieldsException;
import com.ligne.bleue.uphf.exeptions.Success;
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
		try {
			Activity a = activityService.getActivity(id);
			return ResponseEntity.ok().body(a);
		} catch (Exception e) {
			throw new ActivityNotFoundException(id);
		}
	}

	/**
	 * Get all activities
	 **/
	@GetMapping("/all")
	public List<Activity> getAllActivities() {
		if (activityService.getAllActivities().isEmpty()) {
			throw new ActivityNotFoundException();
		} else {
			return activityService.getAllActivities();
		}
	}

	/**
	 * Create a new activity
	 **/
	@PostMapping("/save")
	public ResponseEntity<Success> createActivity(@Valid @RequestBody Activity a) {
		if (a.getLevel() == 0 || a.getLocation() == null || a.getName() == null || a.getTime() == null
				|| a.getType() == null) {
			throw new EmptyFieldsException();
		} else {
			return ResponseEntity.ok().body(new Success(true, "Activité créée avec succès.", new Date()));

		}
	}

	/**
	 * Update an activity
	 **/
	@PutMapping("/{id}")
	public ResponseEntity<Success> updateActivity(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Activity activityDetails) {
		Activity a = null;

		try {
			a = activityService.getActivity(id);

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

			return ResponseEntity.ok().body(new Success(true, "Activité modifiée avec succès.", new Date()));

		} catch (Exception e) {
			if (a == null) {
				throw new ActivityNotFoundException(id);
			} else {
				throw new EmptyFieldsException();
			}
		}
	}
}
