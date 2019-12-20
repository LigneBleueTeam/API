package com.ligne.bleue.uphf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity {

	@Id
	@GeneratedValue
	private Long activityId;
	private int level;
	private String location;
	private String name;
	private String time;
	private String type;
	
	public Activity(int level, String location, String name, String time, String type) {
		super();
		this.level = level;
		this.location = location;
		this.name = name;
		this.time = time;
		this.type = type;
	}

	public Activity() {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
