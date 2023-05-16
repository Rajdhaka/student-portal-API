package com.geekster.mappingPractice.controllers;

import com.geekster.mappingPractice.models.Address;
import com.geekster.mappingPractice.models.Course;
import com.geekster.mappingPractice.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;
    @PostMapping()
    public void addCourse(@RequestBody Course course){
        courseService.addCourse(course);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses(){
        List<Course>allCourses =courseService.findAllCourses();
        HttpStatus status;

        if(allCourses.isEmpty()){
            status = HttpStatus.NO_CONTENT;
        }
        else{
            status = HttpStatus.OK;
        }
        return new ResponseEntity<List<Course>>(allCourses,status);
    }


    @PutMapping("courseId/{courseId}/courseTitle/{courseTitle}")
    public ResponseEntity<String>modifyCourse(@PathVariable Long courseId,@PathVariable String courseTitle){
        HttpStatus status;
        String message ;
        try{
            courseService.updateCourse(courseId,courseTitle);
            status = HttpStatus.OK;
            message = "Course Title  updated successfully !!!";

        }
        catch (Exception ex){

            status = HttpStatus.NOT_MODIFIED;
            message = "Course with courseId "+courseId+" does not exist";
            System.out.println(ex);


        }
        return new ResponseEntity<String>(message,status);
    }

   @DeleteMapping("courseId/{courseId}")
    public ResponseEntity<String>removeCourse(@PathVariable Long courseId){
        HttpStatus status;
        String message = null;
        try{
            courseService.deleteCourse(courseId);
            status = HttpStatus.OK;
            message = "Course with courseId "+courseId+" deleted successfully !!!";

        }
        catch (Exception ex){
            status = HttpStatus.BAD_REQUEST;
            message = "course does not exist";
            System.out.println(ex);
        }
        return new ResponseEntity<String>(message,status);
    }

}
