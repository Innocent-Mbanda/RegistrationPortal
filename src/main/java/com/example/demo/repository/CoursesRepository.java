package com.example.demo.repository;

import com.example.demo.model.CoursesModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CoursesRepository  extends MongoRepository<CoursesModel, String> {

    @Query("{'name': ?0}")
    List<CoursesModel>findByNames(String name);
}
