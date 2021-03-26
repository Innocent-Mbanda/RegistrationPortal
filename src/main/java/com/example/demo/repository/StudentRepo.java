package com.example.demo.repository;

import com.example.demo.model.StudentModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface StudentRepo extends MongoRepository<StudentModel, String> {
    @Query("{'names': ?0}")
    List<StudentModel> findByNames(String name);


}




