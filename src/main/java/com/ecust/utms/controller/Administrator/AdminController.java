package com.ecust.utms.controller.Administrator;

import com.ecust.utms.mapper.AdministratorMapper;
import com.ecust.utms.mapper.AnnouncementMapper;
import com.ecust.utms.mapper.SubjectMapper;
import com.ecust.utms.model.Administrator;
import com.ecust.utms.model.Announcement;
import com.ecust.utms.model.Message;
import com.ecust.utms.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdministratorMapper administratorMapper;
    @Autowired
    SubjectMapper subjectMapper;
    @Autowired
    AnnouncementMapper announcementMapper;

    @GetMapping("/users")
    public String toPersonalCentre(HttpSession session){
        Administrator user = (Administrator) session.getAttribute("loginuser");
        Administrator admin = administratorMapper.getAd(user.getTID());
        session.setAttribute("loginuser",admin);
        return "super/superInfo";
    }

    @GetMapping("/topics")
    public String toTopicPage(Model model, HttpSession session){
        List<Subject> all = subjectMapper.getAllSub();
        model.addAttribute("subs",all);
        return "super/superTopic";
    }

    @GetMapping("/messages")
    public String toMessagePage(Model model, HttpSession session){
        List<Announcement> all = announcementMapper.getAllAn();
        model.addAttribute("anns",all);
        return "super/supermessage";
    }

    @GetMapping("/superInfos")
    public String toSuperInfoPage(Model model, HttpSession session){

        return "super/superUserStu";
    }

}
