package com.sohaib.taskManagementBackend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sohaib.taskManagementBackend.entities.Task;

@Repository
public interface TaskRespository extends JpaRepository<Task, Long> {
  List<Task> findByProgram(long program);
}
