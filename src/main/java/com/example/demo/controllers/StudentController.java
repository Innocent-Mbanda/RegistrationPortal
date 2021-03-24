package com.example.demo.controllers;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class StudentController {
    @Autowired
    private StudentService studentService;
//    @Autowired
//    private StudentModel studentModel;


    @PostMapping("/register")
    public ResponseEntity< StudentModel> createStudent(@RequestBody StudentModel studentData){
        return new ResponseEntity<>(studentService.createStudent(studentData), HttpStatus.CREATED);
    }

    @GetMapping("/students")

   public ResponseEntity <List<StudentModel>>getAllStudents(){
       return new ResponseEntity<>(studentService.getStudents(),HttpStatus.OK) ;
    }


    @GetMapping("students/{id}")
    public ResponseEntity<Optional<StudentModel>> getStudentById(@PathVariable String id){
        return new ResponseEntity<>(studentService.getStudentById(id),HttpStatus.OK) ;
    }




}
