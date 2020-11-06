package com.thoughtworks.capability.gtb.restfulapidesign.api;


import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupList;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupList groupList;

    @Autowired
    StudentList studentList;

    @GetMapping
    public ResponseEntity<List<Group>> groupStudent(){
        return ResponseEntity.ok(groupList.groupStudents(studentList.getALL()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Student>> getGroup(@PathVariable int id){
        return ResponseEntity.ok(groupList.findById(id).getStudentList());
    }


    @PutMapping
    public ResponseEntity changeName(@RequestParam("id")int id, @RequestParam("name")String name){
        groupList.updateGroupName(id,name);
        return ResponseEntity.ok().build();
    }
}
