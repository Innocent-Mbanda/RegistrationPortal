package com.example.demo.service;

import com.example.demo.model.CoursesModel;
import com.example.demo.model.StudentModel;
import com.example.demo.repository.CoursesRepository;
import com.example.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    @Autowired
    private CoursesRepository coursesRepository;
     public StudentModel createStudent(StudentModel studentdata){
         return studentRepo.save(studentdata);
     }

     public List<StudentModel> getStudents(){
         return  studentRepo.findAll();
     }

     public Optional<StudentModel>  getStudentById(String id){
         return studentRepo.findById(id);
     }

    public List<StudentModel>  getStudentByName(String name){
        return studentRepo.findByNames(name);
    }

    public Boolean deleteStudentById(String id){
         Optional<StudentModel> isStudentExisit = studentRepo.findById(id);
         if (isStudentExisit.isPresent()){
             studentRepo.deleteById(id);
             return true;
         } else {
             return false;
         }
    }

    public Boolean updateStudentById(String id, StudentModel studentModel){
         Optional<StudentModel>isStudentExist = studentRepo.findById(id);
         if (isStudentExist.isPresent()){
         StudentModel studentData = isStudentExist.get();

         studentData.setNames(studentModel.getNames());
         studentData.setAge(studentModel.getAge());
         studentData.setGender(studentModel.getGender());
         studentData.setPhone(studentModel.getPhone());
             studentRepo.save(studentData);
         return true;
         }
         else {
            return false;
         }
    }

    public Boolean studentEnrollCourse(String studentId, String courseId){
         Optional<StudentModel> studentData =studentRepo.findById(studentId);
         if (studentData.isPresent()){
           Optional  <CoursesModel> coursesData =coursesRepository.findById(courseId);
           if (coursesData.isPresent()){
               StudentModel studentInfo = studentData.get();
               CoursesModel courseInfo = coursesData.get();

//               studentInfo.getCourses().add(courseInfo);
               List<Object>course =new ArrayList<>();
               course.add(courseInfo);
               studentInfo.setCourses(course);
                studentRepo.save(studentInfo);
                return true;

           }
           return false;

         }
         return false;


    }



}
