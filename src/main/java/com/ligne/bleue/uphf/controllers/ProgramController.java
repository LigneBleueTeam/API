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

import com.ligne.bleue.uphf.models.Program;
import com.ligne.bleue.uphf.services.ProgramService;

@RestController
@RequestMapping("/api/program")
public class ProgramController {

	@Autowired
	ProgramService programService;

	/**
	 * Get a program by ID
	 **/
	@GetMapping("/{id}")
	public ResponseEntity<Program> getProgram(@PathVariable(value = "id") Long id) {
		Program program = programService.getProgram(id);
		if (program == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(program);
		}
	}

	/**
	 * Get all programs
	 **/
	@GetMapping("/all")
	public List<Program> getAllPrograms() {
		return programService.getAllPrograms();
	}

	/**
	 * Create a new program
	 **/
	@PostMapping("/save")
	public Program createProgram(@Valid @RequestBody Program program) {
		return programService.saveProgram(program);
	}

	/**
	 * Update a program
	 **/
	@PutMapping("/{id}")
	public ResponseEntity<Program> updateProgram(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Program programDetails) {
		Program program = programService.getProgram(id);

		if (program == null) {
			return ResponseEntity.notFound().build();
		} else {
			if (programDetails.getLevel() != 0) {
				program.setLevel(programDetails.getLevel());
			}
			if (programDetails.getName() != null) {
				program.setName(programDetails.getName());
			}
			if (programDetails.getObjective() != 0) {
				program.setObjective(programDetails.getObjective());
			}

			Program updatedProgram = programService.saveProgram(program);
			return ResponseEntity.ok().body(updatedProgram);
		}
	}

}
