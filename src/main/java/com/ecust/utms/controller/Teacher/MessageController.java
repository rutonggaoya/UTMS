package com.ecust.utms.controller.Teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/teacher")
public class MessageController {

    @GetMapping("/messages")
    public String toMesPaget(){

        return "Teacher/TeacherMessage";
    }
}
