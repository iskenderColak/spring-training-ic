package com.icolak.controller;

import com.icolak.dto.TeacherDTO;
import com.icolak.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final TeacherService teacherService;

    public SchoolController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> readAllTeacher() {
        List<TeacherDTO> teachers = teacherService.findAll();
        return teachers;
    }
}
