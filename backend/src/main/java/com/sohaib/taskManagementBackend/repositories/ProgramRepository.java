package com.sohaib.taskManagementBackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sohaib.taskManagementBackend.entities.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {

  List<Program> findByAdmin(long admin);
}