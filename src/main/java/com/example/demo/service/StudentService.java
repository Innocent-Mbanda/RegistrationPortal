package com.example.demo.service;

import com.example.demo.model.StudentModel;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
     public StudentModel createStudent(StudentModel studentdata){
         return studentRepo.save(studentdata);
     }

     public List<StudentModel> getStudents(){
         return  studentRepo.findAll();
     }


//    public StudentModel createStudent() {
//         return  studentRepo.findById(id).get();
//
//    }
}
