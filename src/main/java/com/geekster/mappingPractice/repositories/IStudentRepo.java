package com.geekster.mappingPractice.repositories;

import com.geekster.mappingPractice.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends JpaRepository<Student,Long> {
    Student findByStudentId(Long studentId);

    @Modifying
    @Query(value = "update student set student_phone_number=:phoneNumber where student_id=:studentId",nativeQuery = true)
    void updateStudent(Long studentId, String phoneNumber);
}
