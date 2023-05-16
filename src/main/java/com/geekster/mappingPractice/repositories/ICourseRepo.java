package com.geekster.mappingPractice.repositories;

import com.geekster.mappingPractice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepo extends JpaRepository<Course,Long> {
    @Modifying
    @Query(value = "update course set course_title=:courseTitle where course_id=:courseId",nativeQuery = true)
    void updateCourse(Long courseId, String courseTitle);
}
