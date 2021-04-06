package com.example.demo.controllers;

import com.example.demo.model.CoursesModel;
import com.example.demo.service.CoursesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class CourseController {

    @Autowired
    private CoursesServices coursesServices;

    @PostMapping("course")
    public ResponseEntity<CoursesModel> createCourses(@RequestBody CoursesModel courseInfo){
        return new ResponseEntity<>(coursesServices.createCourses(courseInfo), HttpStatus.CREATED);
    }

    @GetMapping("courses")

    public ResponseEntity<List<CoursesModel>>getAllCourses(){
        return new ResponseEntity<>(coursesServices.createCourses(),HttpStatus.OK);
    }

    @GetMapping("courses/{id}")
    public ResponseEntity<Optional<CoursesModel>>getCoursesById(@PathVariable String id){
        return new ResponseEntity<>(coursesServices.getCourseById(id),HttpStatus.OK);
    }

    @GetMapping("courses/name")

    public ResponseEntity <List<CoursesModel>>getCoursesByName(String name){
        return new ResponseEntity<>(coursesServices.getCoursesByName(name),HttpStatus.CREATED);
    }

@DeleteMapping("courses/{id}")

    public ResponseEntity<String>deleteCourseById(@PathVariable String id){
       if (coursesServices.deleteCourseById(id)){
           return new ResponseEntity<String>("Course deleted",HttpStatus.OK);
       } else {
           return new ResponseEntity<String>("Course does not exisit, delete failured",HttpStatus.OK);
       }
}





}
