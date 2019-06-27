package com.ecust.utms.controller.Teacher;

import com.ecust.utms.mapper.TeacherMapper;
import com.ecust.utms.mapper.ThesisMapper;
import com.ecust.utms.model.EvaluateThesis;
import com.ecust.utms.model.Teacher;
import com.ecust.utms.model.Thesis;
import com.ecust.utms.model.ThesisPageData;
import com.ecust.utms.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class ThesisController {

    @Autowired
    ThesisMapper thesisMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    FileService fileService;

    @GetMapping("/thesises")
    public String toThesisPage(Model model, HttpSession session){
        Teacher user = (Teacher)session.getAttribute("loginuser");
        List<ThesisPageData> all = thesisMapper.getAllTPD(user.getTID());
        model.addAttribute("tpds",all);
        return "Teacher/TeacherThesis";
    }

    @GetMapping("/Files/download")
    public String download(@RequestParam("path") String path, HttpServletResponse response){
        return fileService.downloadFile(path, response);
    }

    @ResponseBody
    @GetMapping("/comment")
    public String comment(@RequestParam("comment") String comment,@RequestParam("thesisID") Integer ThesisID,HttpSession session){
//        System.out.println(ThesisID+comment);
        Teacher user = (Teacher)session.getAttribute("loginuser");
        EvaluateThesis et = new EvaluateThesis();
        et.setEContent(comment);
        et.setEGrade(100);
        et.setThesisID(ThesisID);
        et.setTID(user.getTID());
        System.out.println(et.toString());
        teacherMapper.evaluateThesis(et);
        return "redirect:/thesises";
    }
}
