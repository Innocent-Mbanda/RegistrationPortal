package com.example.demo.controllers;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

   public List<StudentModel>getAllStudents(){
       return studentService.getStudents();
    }

//    @GetMapping("/student/{id}")

//   public StudentModel getSingleStudent (@PathVariable Long id){
//        return  studentService.createStudent();
//    }




}
