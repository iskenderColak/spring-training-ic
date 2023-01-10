package com.icolak.controller;

import com.icolak.dto.CourseDTO;
import com.icolak.dto.ResponseWrapper;
import com.icolak.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {

    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Version", "icolak.v3")
                .header("Operation", "Get List")
                .body(new ResponseWrapper("Course list successfully retrieved", courseService.getCourses()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") long courseId) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Operation", "Get Course")
                .body(new ResponseWrapper("Course-" + courseId + " retrieved successfully", courseService.getCourseById(courseId)));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCourse(@RequestBody CourseDTO courseDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Version", "icolak.V3")
                .header("Operation", "Create Course")
                .body(new ResponseWrapper("Course created successfully", courseService.createCourse(courseDTO)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ResponseWrapper> updateCourseById(@PathVariable("id") long courseId, @RequestBody CourseDTO courseDTO) {
        courseService.updateCourse(courseId, courseDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ResponseWrapper> deleteCourseById(@PathVariable("id") long courseId) {
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }

}
