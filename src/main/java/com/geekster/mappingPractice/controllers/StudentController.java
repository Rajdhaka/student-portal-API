package com.geekster.mappingPractice.controllers;

import com.geekster.mappingPractice.models.Student;
import com.geekster.mappingPractice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.QAbstractAuditable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
    @GetMapping("/studentId/{studentId}")
    public ResponseEntity<Student>getStudent(@PathVariable Long studentId){
       Student  student = studentService.getStudent(studentId);
       HttpStatus status;
       if(student ==null){
           status = HttpStatus.BAD_REQUEST;
       }
       else{
           status = HttpStatus.OK;
       }
       return new ResponseEntity<Student>(student,status);
    }

    @PutMapping("/studentId/{studentId}/phoneNumber/{phoneNumber}")
    public ResponseEntity<String>modifyStudent(@PathVariable Long studentId, @PathVariable String phoneNumber){
        HttpStatus status;
        String message = null;
        try {
            studentService.modifyStudent(studentId, phoneNumber);
            status = HttpStatus.OK;
            message = "student updated successfully !!!";
        }
        catch(Exception ex){
            status = HttpStatus.NOT_MODIFIED;
            message = "Not valid student";
            System.out.println(ex);
        }
        return new ResponseEntity<String>(message,status);
    }
    @DeleteMapping("studentId/{studentId}")
    public ResponseEntity<String>removeStudent(@PathVariable Long studentId){
        HttpStatus status;
        String message = null;
        try{
            studentService.deleteStudent(studentId);
            status = HttpStatus.OK;
            message = "Student deleted successfully !!!";

        }
        catch (Exception ex){
            status = HttpStatus.BAD_REQUEST;
            message = "Student does not exist";
            System.out.println(ex);
        }
        return new ResponseEntity<String>(message,status);
    }
}
