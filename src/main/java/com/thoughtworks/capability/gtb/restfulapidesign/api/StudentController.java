package com.thoughtworks.capability.gtb.restfulapidesign.api;


import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentList;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    StudentList studentList;

    @PostMapping
    public ResponseEntity addStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        studentList.removeStudent(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateStudent(@RequestBody Student student){
        studentList.updateStudent(student);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudent() {
        return ResponseEntity.ok(studentList.getALL());
    }
    @GetMapping
    public ResponseEntity<List<Student>> fliterStudent(@RequestParam(value = "gender")String gender){
        return ResponseEntity.ok(studentList.fillterStudentByGender(gender));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
        return ResponseEntity.ok(studentList.findStudent(id));
    }

}
