package com.ecust.utms.controller;

import com.ecust.utms.mapper.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @Autowired
//    AdministratorMapper administratorMapper;
//还未连接数据库的数据 单选框未使用
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("inputPassword") String inputPassword,
                        Map<String,Object> map, HttpSession session){
        //administratorMapper.getAllAd();
        if(!StringUtils.isEmpty(username) && "123".equals(inputPassword)){
            session.setAttribute("loginuser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户名或密码错误");
            return "login.html";
        }
    }
}
