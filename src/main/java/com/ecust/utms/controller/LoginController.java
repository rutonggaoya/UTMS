package com.ecust.utms.controller;

import com.ecust.utms.mapper.AdministratorMapper;
import com.ecust.utms.mapper.StudentMapper;
import com.ecust.utms.mapper.TeacherMapper;
import com.ecust.utms.model.Administrator;
import com.ecust.utms.model.Student;
import com.ecust.utms.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    AdministratorMapper administratorMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;


    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("inputPassword") String inputPassword,
                        @RequestParam("user") String usertype,
                        Map<String,Object> map, HttpSession session){
        if("Student".equals(usertype)){
            Student stu = studentMapper.getStu(username);
            if(stu==null){
                map.put("msg","用户名为空");
                return "login.html";
            }
            else if(stu.getSID().equals(username) && stu.getPasswd().equals(inputPassword)){
                session.setAttribute("loginuser",username);
                return "redirect:/main.html";
            }else {
                map.put("msg","用户名或密码错误");
                return "login.html";
            }
        }
        else if("Teacher".equals(usertype)){
            Teacher tea = teacherMapper.getTea(username);
            if(tea==null){
                map.put("msg","用户名为空");
                return "login.html";
            }
            else if(tea.getTID().equals(username) && tea.getPasswd().equals(inputPassword)){
                session.setAttribute("loginuser",username);
                return "redirect:/main.html";
            }else {
                map.put("msg","用户名或密码错误");
                return "login.html";
            }
        }else{
            Administrator ad = administratorMapper.getAd(username);
            if(ad==null){
                map.put("msg","用户名为空");
                return "login.html";
            }
            else if(ad.getTID().equals(username) && ad.getPasswd().equals(inputPassword)){
                session.setAttribute("loginuser",username);
                return "redirect:/main.html";
            }else {
                map.put("msg","用户名或密码错误");
                return "login.html";
            }
        }

    }
}