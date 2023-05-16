package com.geekster.mappingPractice.services;

import com.geekster.mappingPractice.models.Course;
import com.geekster.mappingPractice.models.Student;
import com.geekster.mappingPractice.repositories.ICourseRepo;
import com.geekster.mappingPractice.repositories.IStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    ICourseRepo courseRepo;

    @Autowired
    IStudentRepo studentRepo;

    public  List<Course> findAllCourses() {
       return courseRepo.findAll();
    }

    public void addCourse(Course course) {
        List<Student>myStudents = course.getStudentList();
        for(Student student:myStudents){
            List<Course>courseList = new ArrayList<>();
            courseList.add(course);
            student.setCourseList(courseList);
        }
        courseRepo.save(course);
    }
    @Transactional
    public void updateCourse(Long courseId, String courseTitle) {
        boolean isValidCourse = courseRepo.existsById(courseId);

        if(!isValidCourse){
            throw new IllegalStateException("Not valid address");
        }
        courseRepo.updateCourse(courseId, courseTitle);
    }

    public void deleteCourse(Long courseId) {
        boolean isValidCourse = courseRepo.existsById(courseId);

        if(!isValidCourse){
            throw new IllegalStateException("Not valid address");
        }
        courseRepo.deleteById(courseId);
    }
}
