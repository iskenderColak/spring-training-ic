package com.icolak.controller;

import com.icolak.enums.Gender;
import com.icolak.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/mentorTask")
    public String displayMentorInfo(Model model) {
        List<Mentor> mentorList = new ArrayList<>();
        Mentor mike = new Mentor("Mike", "Smith", 45, Gender.MALE);
        Mentor tom = new Mentor("Tom", "Hanks", 45, Gender.MALE);
        Mentor ammy = new Mentor("Ammy", "Bryan", 45, Gender.FEMALE);
        mentorList.addAll(Arrays.asList(mike, tom, ammy));

        model.addAttribute("mentor1", mike);
        model.addAttribute("mentor2", tom);
        model.addAttribute("mentor3", ammy);
        model.addAttribute("mentors", mentorList);

        return "mentor/mentor-info";
    }
}
