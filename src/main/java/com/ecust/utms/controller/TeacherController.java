package com.ecust.utms.controller;


import com.ecust.utms.mapper.DepartmentMapper;
import com.ecust.utms.mapper.TeacherMapper;
import com.ecust.utms.model.Department;
import com.ecust.utms.model.Subject;
import com.ecust.utms.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
public class TeacherController {
    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    DepartmentMapper departmentMapper;


    @GetMapping("/teachers")
    public String toPersonalCentre(HttpSession session){
        Teacher user = (Teacher)session.getAttribute("loginuser");
        Teacher tea = teacherMapper.getTea(user.getTID());
        session.setAttribute("loginuser",tea);
        return "Teacher/TeacherPerson";
    }

    @GetMapping("/teacher/{TID}")
    public String toEditInfo(@PathVariable("TID") String TID, Model model){
        Collection<Department> depts = departmentMapper.getAllDept();
        model.addAttribute("depts",depts);
        //修改添加二合一页面
        return "Teacher/TeacherEditInfo";
    }

    @PostMapping("/teacher")
    public String EditInfo(Teacher teacher){//拿不到Teacher对象
        System.out.println(teacher==null);
        System.out.println(teacher.toString());
        teacherMapper.updateTea(teacher);
        return "redirect:/teachers";//重定向
    }

//    @GetMapping("/subjects")
//    public String toSubjectPage(Model model){
//        Collection<Subject> all =
//        return "";
//    }

}
