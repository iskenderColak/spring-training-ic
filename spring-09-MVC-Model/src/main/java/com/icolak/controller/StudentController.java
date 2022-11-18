package com.icolak.controller;

import com.icolak.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model) {
        model.addAttribute("name", "icolak");
        model.addAttribute("course", "MVC");

        String classSubject = "Spring Boot";
        model.addAttribute("subject", classSubject);

        int studentId = new Random().nextInt();
        model.addAttribute("id", studentId);

        List<Integer> numberList = new ArrayList<>(Arrays.asList(4,5,6,7));
        model.addAttribute("numbers", numberList);

        LocalDate ld = LocalDate.now();
        model.addAttribute("date", ld);

        Student student = new Student(1,"Iskender", "Colak");
        model.addAttribute("student", student);

        return "student/welcome";
    }
}
