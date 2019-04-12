package com.yule.sms.studentservice.controller;

import com.yule.sms.studentservice.model.Course;
import com.yule.sms.studentservice.model.Student;
import com.yule.sms.studentservice.model.Telephone;
import com.yule.sms.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "smscloud")
public class StudentController {
    @Autowired
    StudentService studentService;

//    @RequestMapping("/hello")
//    public String greeting(){
//        return "helloo..";
//    }
//
//    @RequestMapping("/hello2")
//    public String greeting2(@RequestParam String name){
//        return "helloo.." + name;
//    }
//
//    @RequestMapping(value = "/student", method = RequestMethod.POST)
//    public Student save(@RequestBody Student student){
//        System.out.println(student.getName()+ " "+ student.getCity());
//        return student;
//    }
//
//    @RequestMapping(value = "/student", method = RequestMethod.GET)
//    public ResponseEntity<Student> fetch(){
//
//        return ResponseEntity.noContent().build();
//    }
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
//        System.out.println(student.getName()+ " "+ student.getCity());
        return studentService.save(student);
    }

    @RequestMapping("/student")
    public List<Student> fetch(){
        return studentService.fetch();
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> fetch(@PathVariable Integer id){
        if(id<=0){
            return ResponseEntity.badRequest().build();
        }
        else{
            Student student = studentService.fetch(id);
            if(student==null){
                return ResponseEntity.notFound().build();
            }
            else {
                return ResponseEntity.ok(student);
            }
        }
    }

    @RequestMapping(value = "/student/{id}/course", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> fetchCourses(@PathVariable Integer id){
        if(id<=0){
            return ResponseEntity.badRequest().build();
        }
        else{
            Student student = studentService.fetch(id);
            if(student==null){
                return ResponseEntity.notFound().build();
            }
            else {
                return ResponseEntity.ok(student.getCourses());
            }
        }
    }


    @RequestMapping(value = "/student/{id}/telephone", method = RequestMethod.GET)
    public ResponseEntity<List<Telephone>> fetchTelephone(@PathVariable Integer id){
        if(id<=0){
            return ResponseEntity.badRequest().build();
        }
        else{
            Student student = studentService.fetch(id);
            if(student==null){
                return ResponseEntity.notFound().build();
            }
            else {
                return ResponseEntity.ok(student.getTelephone());
            }
        }
    }
}
