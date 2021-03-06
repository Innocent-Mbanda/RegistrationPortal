package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "studentsInfo")
public class StudentModel {
    @Id
    private String studentId;
    private String names;
    private String gender;
    private String phone;
    private int age;
    private String email;
    private List<Object>courses;
//    private String [] grades;


    public StudentModel(){

    }

    public List<Object> getCourses() {
        return courses;
    }

    public void setCourses(List<Object> courses) {
        this.courses = courses;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getNames() {
        return names;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return age;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


