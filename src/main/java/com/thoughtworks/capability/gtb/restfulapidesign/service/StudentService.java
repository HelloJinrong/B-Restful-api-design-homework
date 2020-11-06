package com.thoughtworks.capability.gtb.restfulapidesign.service;


import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentList studentList;

    public void createStudent(Student student)
    {
        int id = studentList.getLength()+1;
        Student newStudent = new Student(id ,student.getName(),student.getGender(),"");
        studentList.addStudent(newStudent);
    }
}
