package com.ecust.utms.controller.Teacher;

import com.ecust.utms.mapper.ThesisMapper;
import com.ecust.utms.model.Teacher;
import com.ecust.utms.model.Thesis;
import com.ecust.utms.model.ThesisPageData;
import com.ecust.utms.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class ThesisController {

    @Autowired
    ThesisMapper thesisMapper;
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
}
