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

import com.ligne.bleue.uphf.exeptions.EmptyFieldsException;
import com.ligne.bleue.uphf.exeptions.ProgramNotFoundException;
import com.ligne.bleue.uphf.exeptions.Success;
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
		try {
			Program program = programService.getProgram(id);
			return ResponseEntity.ok().body(program);
		} catch (Exception e) {
			throw new ProgramNotFoundException(id);
		}
	}

	/**
	 * Get all programs
	 **/
	@GetMapping("/all")
	public List<Program> getAllPrograms() {
		if (programService.getAllPrograms().isEmpty()) {
			throw new ProgramNotFoundException();
		} else {
			return programService.getAllPrograms();
		}
	}

	/**
	 * Create a new program
	 **/
	@PostMapping("/save")
	public ResponseEntity<Success> createProgram(@Valid @RequestBody Program program) {
		if (program.getLevel() == 0 || program.getName() == null || program.getObjective() == 0) {
			throw new EmptyFieldsException();
		} else {
			programService.saveProgram(program);
			return ResponseEntity.ok().body(new Success(true, "Programme crée avec succès.", new Date()));
		}
	}

	/**
	 * Update a program
	 **/
	@PutMapping("/{id}")
	public ResponseEntity<Success> updateProgram(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Program programDetails) {
		Program program = null;
		try {
			program = programService.getProgram(id);

			if (programDetails.getLevel() != 0) {
				program.setLevel(programDetails.getLevel());
			}
			if (programDetails.getName() != null) {
				program.setName(programDetails.getName());
			}
			if (programDetails.getObjective() != 0) {
				program.setObjective(programDetails.getObjective());
			}

			programService.saveProgram(program);
			return ResponseEntity.ok().body(new Success(true,"Programme modifié avec succès.",new Date()));
			
		} catch (Exception e) {
			if (program == null) {
				throw new ProgramNotFoundException(id);
			} else {
				throw new EmptyFieldsException();
			}
		}
	}

}
