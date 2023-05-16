package com.geekster.mappingPractice.services;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.geekster.mappingPractice.models.Student;
import com.geekster.mappingPractice.repositories.IStudentRepo;
import jakarta.transaction.Transactional;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;
    public void addStudent(Student student) {

        studentRepo.save(student);
    }

    public Student getStudent(Long studentId) {
       return studentRepo.findByStudentId(studentId);
    }
    @Transactional
    public void modifyStudent(Long studentId, String phoneNumber) {
        boolean isValidAddress = studentRepo.existsById(studentId);

        if(!isValidAddress){
            throw new IllegalStateException("Not valid address");
        }
        studentRepo.updateStudent(studentId, phoneNumber);
    }

    public void deleteStudent(Long studentId) {
        boolean isValidAddress = studentRepo.existsById(studentId);

        if(!isValidAddress){
            throw new IllegalStateException("Not valid student");
        }
        studentRepo.deleteById(studentId);
    }
}
