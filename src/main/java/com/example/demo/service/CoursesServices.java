package com.example.demo.service;

import com.example.demo.model.CoursesModel;
import com.example.demo.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesServices {

    @Autowired
    private CoursesRepository coursesRepository;

    public CoursesModel createCourses (CoursesModel courseData){
        return coursesRepository.save(courseData);
    }


    public List<CoursesModel> createCourses(){
        return coursesRepository.findAll();
    }

    public Optional<CoursesModel> getCourseById(String id) {
        return coursesRepository.findById(id);
    }

    public List<CoursesModel> getCoursesByName(String name){
        return coursesRepository.findByNames(name);
    }

    public boolean deleteCourseById(String id){
        Optional<CoursesModel>isCourseAvailable =coursesRepository.findById(id);
            if(isCourseAvailable.isPresent()){
                coursesRepository.deleteById(id);
                return true;
            } else {
                return false;
            }

    }
}


