package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentList {
    private final String[] studentsName = {
            "成吉思汗", "鲁班七号", "太乙真人", "钟无艳", "花木兰", "雅典娜", "芈月", "白起", "刘婵",
            "庄周", "马超", "刘备", "哪吒", "大乔", "蔡文姬"
    };
    private List<Student> studentList = new ArrayList<>();

    public StudentList() {
        for (int i = 0; i < studentsName.length; i++) {
            String gender;
            if (i % 2 == 0) {
                gender = "female";
            } else
                gender = "male";
            studentList.add(new Student(i + 1, studentsName[i], gender, ""));
        }
    }

    public int getLength(){
        return studentList.size();
    }
    public List<Student> getALL() {
        return studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(int id) {
        studentList.remove(id - 1);
    }

    public List<Student> fillterStudentByGender(String gender) {
        List<Student> res = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getGender().equals(gender))
                res.add(student);
        }
        return res;
    }

    public Student findStudent(int id) {
        return studentList.get(id - 1);
    }


    public void updateStudent(Student newstudent) {
        Student originStudent = findStudent(newstudent.getId());
        if (newstudent.getGender() != null)
            originStudent.setGender(newstudent.getGender());
        if (newstudent.getName() != null)
            originStudent.setGender(newstudent.getName());
        if (newstudent.getNote() != null)
            originStudent.setNote(newstudent.getNote());
        studentList.remove(newstudent.getId());
        studentList.add(newstudent.getId(), originStudent);
    }


}
