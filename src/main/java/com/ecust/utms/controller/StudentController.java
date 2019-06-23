package com.ecust.utms.controller;

import com.ecust.utms.mapper.StudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/message")
    public String showMessage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        logger.trace("--->Student: " + session.getAttribute("loginuser") + "");
        map.put("loginuser", "10161858");
        return "Student/message";
    }
}
