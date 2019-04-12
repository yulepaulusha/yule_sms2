package com.yule.sms.studentservice.service;

import com.yule.sms.studentservice.model.Course;
import com.yule.sms.studentservice.model.Student;
import com.yule.sms.studentservice.model.Telephone;
import com.yule.sms.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        for(Telephone telephone: student.getTelephone()){
            telephone.setStudent(student);
        }
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetch() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetch(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }
        else return null;
    }
}
