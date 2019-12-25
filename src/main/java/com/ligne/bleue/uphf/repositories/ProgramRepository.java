package com.ligne.bleue.uphf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ligne.bleue.uphf.models.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
	
}
