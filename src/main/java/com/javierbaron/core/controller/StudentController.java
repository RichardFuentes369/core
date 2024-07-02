package com.javierbaron.core.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javierbaron.core.entity.Student;
import com.javierbaron.core.service.StudentService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(path = "api/v1/stundents")

public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping
  public List<Student> getAll(){
    return studentService.getStudents();
  }

  @GetMapping("/{studentId}")
  public Optional<Student> getById(@PathVariable("studentId") Long studentId){
    return studentService.getStudent(studentId);
  }

  @PostMapping("/add-student")
  public void saveUpdate(@RequestBody Student student) {
    studentService.saveOrUpdate(student);
  }

  @DeleteMapping("/delete-student/{studentId}")
  public void delete(@PathVariable("studentId") Long studentId) {
    studentService.delete(studentId);
  }  

}
