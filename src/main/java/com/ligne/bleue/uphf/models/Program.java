package com.ligne.bleue.uphf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Program {

	@Id
	@GeneratedValue
	private Long programId;
	private int level;
	private String name;
	private int objective;
	private float minHeight, maxHeight, minWeight, maxWeight;

	public Program(int level, String name, int objective, float minHeight, float maxHeight, float minWeight,
			float maxWeight) {
		super();
		this.level = level;
		this.name = name;
		this.objective = objective;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.minWeight = minWeight;
		this.maxWeight = maxWeight;
	}

	public Program() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getProgramId() {
		return programId;
	}

	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getObjective() {
		return objective;
	}

	public void setObjective(int objective) {
		this.objective = objective;
	}

	public float getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(float minHeight) {
		this.minHeight = minHeight;
	}

	public float getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(float maxHeight) {
		this.maxHeight = maxHeight;
	}

	public float getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(float minWeight) {
		this.minWeight = minWeight;
	}

	public float getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(float maxWeight) {
		this.maxWeight = maxWeight;
	}

}
