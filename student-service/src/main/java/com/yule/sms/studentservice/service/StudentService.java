package com.yule.sms.studentservice.service;

import com.yule.sms.studentservice.model.Student;

import java.util.List;

public interface StudentService {

    Student save(Student student);
    List<Student> fetch();
    Student fetch(Integer student);
}
