package com.ligne.bleue.uphf.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ligne.bleue.uphf.models.Program;
import com.ligne.bleue.uphf.repositories.ProgramRepository;

@Service
public class ProgramService {
	
	@Autowired
	ProgramRepository programRepo;
	
	/**
	 * Get all programs
	 * **/
	public List<Program> getAllPrograms() {
		return programRepo.findAll();
	}
	
	/**
	 * Get a program by ID
	 * **/
	public Program getProgram(Long programId) {
		return programRepo.findById(programId).get();
	}
	
	/**
	 * Save a program
	 * **/
	public Program saveProgram(Program p) {
		return programRepo.save(p);
	}
}
