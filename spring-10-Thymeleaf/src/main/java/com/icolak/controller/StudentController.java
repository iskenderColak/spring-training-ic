package com.icolak.controller;

import com.icolak.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/register") // localhost:8080/student/register
    public String register(Model model) {

        model.addAttribute("studentList", DataGenerator.createStudent());

        return "student/register";
    }

    @RequestMapping("/welcome") // localhost:8080/student/welcome
    public String welcome() {


        return "student/welcome";
    }

}
