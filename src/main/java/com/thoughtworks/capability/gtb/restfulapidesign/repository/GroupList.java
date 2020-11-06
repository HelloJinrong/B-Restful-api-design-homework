package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Configuration
public class GroupList {
    private final StudentList studentList;
    private final int GROUPNUMBER = 6;
    private List<Group> groupList=new ArrayList<>();

    public GroupList(StudentList studentList) {
        this.studentList = studentList;
    }

    public List<Group> findAll(){
        return groupList;
    }

    public Group findById(int id){
        return groupList.get(id);
    }

    public void updateGroupName(int id, String name){
        Group orginGroup=findById(id-1);
        orginGroup.setName(name);
        groupList.remove(id-1);
        groupList.add(id-1,orginGroup);
    }

    public List<Group> groupStudents(List<Student> studentList){
        Collections.shuffle(studentList);
        int GroupSize = studentList.size()/6;
        int restNum = studentList.size()%6;
        for (int i = 0; i < 6; i++) {
            List<Student> tmp = new ArrayList<>();
            Group group =new Group();
            boolean flag=true;
            for (int k = 0; k < GroupSize ; k++) {
                tmp.add(studentList.get(i *  GroupSize + k));
                if(restNum>0&&flag==true)
                {
                    tmp.add(studentList.get(GroupSize*6 +i));
                    restNum--;
                    flag=false;
                }
            }
            String groupName = "team " + (i + 1);
            group.setId(i+1);
            group.setName(groupName);
            group.setStudentList(tmp);
            groupList.add(group);
        }
        return groupList;
    }
}
