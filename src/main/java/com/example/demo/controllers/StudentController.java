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


    @GetMapping("students/name/{name}")
    public ResponseEntity  < List<StudentModel>> getStudentByName(@PathVariable String name){
        return new ResponseEntity<>(studentService.getStudentByName(name),HttpStatus.OK) ;
    }

    @DeleteMapping("students/{id}")

    public ResponseEntity<String> deleteStudentById(@PathVariable String id){
        if (studentService.deleteStudentById(id)){
           return new ResponseEntity<String>("Delete Successfully ",HttpStatus.OK);
        } else {
           return new ResponseEntity<String>("Student does not exist, delete failed",HttpStatus.EXPECTATION_FAILED) ;
        }



    }


    @PutMapping("students/{id}")

    public ResponseEntity<String>updateStudentById(@PathVariable String  id, @RequestBody  StudentModel studentModel){
        if (studentService.updateStudentById(id, studentModel)){
            return new ResponseEntity<String>("updated Successfully ",HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("cannot be updated",HttpStatus.EXPECTATION_FAILED) ;
        }



    }





}
