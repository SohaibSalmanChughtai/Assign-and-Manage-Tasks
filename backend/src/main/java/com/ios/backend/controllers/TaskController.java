package com.ios.backend.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ios.backend.dto.NewTaskDTO;
import com.ios.backend.entities.Task;
import com.ios.backend.resources.TaskListResource;
import com.ios.backend.resources.TaskRecordListResource;
import com.ios.backend.services.TaskService;
import com.ios.backend.utils.Client;

@RestController
public class TaskController {

  final String clientUrl = Client.clientUrl;

  @Autowired
  private TaskService service;

  @PostMapping("/createTask")
  @CrossOrigin(origins = clientUrl)
  public ResponseEntity<Boolean> createTask(@RequestBody NewTaskDTO newTaskDto) {
    Task task = new Task();
    BeanUtils.copyProperties(newTaskDto.getTask(), task);
    service.createTask(task, newTaskDto.getTrainee());
    return new ResponseEntity<Boolean>(true,HttpStatus.OK);
  }

  @GetMapping("/getAllTaskRecordByTrainee/{id}")
  @CrossOrigin(origins = clientUrl)
  public ResponseEntity<TaskRecordListResource> getAllTaskRecordByTrainee(@PathVariable("id") Long id) {
    // service call
    TaskRecordListResource trlr = service.getAllTaskRecordOfTrainee(id);
    return new ResponseEntity<TaskRecordListResource>(trlr, HttpStatus.OK);
  }
  
  @GetMapping("/getAllTaskByTrainee/{id}")
  @CrossOrigin(origins = clientUrl)
  public ResponseEntity<TaskListResource> getAllTaskByTrainee(@PathVariable("id") Long id) {
    // service call
    TaskListResource tlr = service.getAllTaskOfTrainee(id);
    return new ResponseEntity<TaskListResource>(tlr, HttpStatus.OK);
  }
  
  @GetMapping("/getAllTaskRecord")
  @CrossOrigin(origins = clientUrl)
  public ResponseEntity<TaskRecordListResource> getAllTaskRecord() {
    // service call
    TaskRecordListResource trlr = service.getAllTaskRecord();
    return new ResponseEntity<TaskRecordListResource>(trlr, HttpStatus.OK);
  }

  @GetMapping("/getAllTaskByProgram/{pid}")
  @CrossOrigin(origins = clientUrl)
  public ResponseEntity<TaskListResource> getAllTaskByProgram(@PathVariable("pid") Long pid) {
    // service call
    TaskListResource tlr = service.getAllTaskByProgram(pid);
    return new ResponseEntity<TaskListResource>(tlr, HttpStatus.OK);
  }
  
  @PostMapping("/updateTaskStatus/{status}")
  @CrossOrigin(origins = clientUrl)
  public ResponseEntity updateTaskStatus(@PathVariable("status") String status) {
    return new ResponseEntity(HttpStatus.OK);
  }
}