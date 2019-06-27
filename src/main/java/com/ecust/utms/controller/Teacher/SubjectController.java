package com.ecust.utms.controller.Teacher;

import com.ecust.utms.mapper.SubjectMapper;
import com.ecust.utms.model.Subject;
import com.ecust.utms.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/teacher")
public class SubjectController {

    @Autowired
    SubjectMapper subjectMapper;

    @GetMapping("/subjects")
    public String toSubjectPage(Model model, HttpSession session){
        Teacher user = (Teacher)session.getAttribute("loginuser");
        List<Subject> all = subjectMapper.getTeaSub(user.getTID());
        model.addAttribute("subs",all);
        return "Teacher/TeacherSubject";
    }

    @PostMapping("/subject")
    public String addSub(Subject subject){
        System.out.println("添加新课题:"+subject.toString());
        subjectMapper.insertSub(subject);
        return "redirect:/teacher/subjects";//重定向
    }

    @DeleteMapping("/subject/{SubjID}")
    public String deleteSub(@PathVariable("SubjID") Integer SubjID){
        subjectMapper.deleteSub(SubjID);
        return "redirect:/teacher/subjects";//重定向
    }
}
