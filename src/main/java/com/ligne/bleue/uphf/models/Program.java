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
	
	public Program(int level, String name, int objective) {
		super();
		this.level = level;
		this.name = name;
		this.objective = objective;
	}

	public Program() {}
	
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
	
}
