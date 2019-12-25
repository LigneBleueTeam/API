package com.ligne.bleue.uphf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ligne.bleue.uphf.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}