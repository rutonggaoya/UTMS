package com.ecust.utms.controller.Student;

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
    public String showMessagePage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        String loginuser = "" + session.getAttribute("loginuser");
        logger.trace("--->Student: " + loginuser);
        map.put("loginuser", loginuser);



        return "Student/message";
    }

    @GetMapping("/topic")
    public String showTopicPage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        String loginuser = "" + session.getAttribute("loginuser");
        logger.trace("--->Student: " + loginuser);
        map.put("loginuser", loginuser);


        return "Student/topic";
    }

    @GetMapping("/person")
    public String showPersonPage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        String loginuser = "" + session.getAttribute("loginuser");
        logger.trace("--->Student: " + loginuser);
        map.put("loginuser", loginuser);


        return "Student/person";
    }

    @GetMapping("/question")
    public String showQuestionPage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        String loginuser = "" + session.getAttribute("loginuser");
        logger.trace("--->Student: " + loginuser);
        map.put("loginuser", loginuser);


        return "Student/question";
    }

    @GetMapping("/dissertation")
    public String showDissertationPage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        String loginuser = "" + session.getAttribute("loginuser");
        logger.trace("--->Student: " + loginuser);
        map.put("loginuser", loginuser);


        return "Student/dissertation";
    }
}
