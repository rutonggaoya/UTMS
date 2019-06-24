package com.ecust.utms.controller;

import com.ecust.utms.mapper.ThesisMapper;
import com.ecust.utms.model.Teacher;
import com.ecust.utms.model.Thesis;
import com.ecust.utms.model.ThesisPageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ThesisController {

    @Autowired
    ThesisMapper thesisMapper;

    @GetMapping("/thesises")
    public String toThesisPage(Model model, HttpSession session){
        Teacher user = (Teacher)session.getAttribute("loginuser");
        List<ThesisPageData> all = thesisMapper.getAllTPD(user.getTID());
        model.addAttribute("tpds",all);
        return "Teacher/TeacherThesis";
    }


}
