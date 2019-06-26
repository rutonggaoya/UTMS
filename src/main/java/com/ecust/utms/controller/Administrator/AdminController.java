package com.ecust.utms.controller.Administrator;

import com.ecust.utms.mapper.AdministratorMapper;
import com.ecust.utms.mapper.AnnouncementMapper;
import com.ecust.utms.mapper.AttachmentMapper;
import com.ecust.utms.mapper.SubjectMapper;
import com.ecust.utms.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AdministratorMapper administratorMapper;
    @Autowired
    SubjectMapper subjectMapper;
    @Autowired
    AnnouncementMapper announcementMapper;
    @Autowired
    AttachmentMapper attachmentMapper;

    @GetMapping("/superInfo")
    public String toPersonalCentre(Model model, HttpSession session){
//        Administrator user = (Administrator) session.getAttribute("loginuser");
//        Administrator admin = administratorMapper.getAd(user.getTID());
//        model.addAttribute("admin", admin);
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
        for (Announcement announcement : all){
            List<Attachment> attachs = attachmentMapper.getAtByAID(announcement.getAID());
            announcement.setAttachments(attachs);
        }
        model.addAttribute("anns",all);
        return "super/supermessage";
    }

    @GetMapping("/messageInfo")
    public String toMessageInfoPage(@RequestParam(value = "AID") String AID, Model model, HttpSession session){
        Announcement announcement = announcementMapper.getAn(Integer.valueOf(AID));
        List<Attachment> attachs = attachmentMapper.getAtByAID(announcement.getAID());
        announcement.setAttachments(attachs);
        model.addAttribute("announcement", announcement);
        return "super/messageInfo";
    }

    @GetMapping("/users")
    public String toSuperInfoPage(Model model, HttpSession session){

        return "super/superUserStu";
    }

    @PostMapping("/announce")
    public String announce(@RequestParam(value = "TID") String TID,
                           @RequestParam(value = "Content") String Content,
                           @RequestParam(value = "Title") String Title,
                           Model model, HttpSession session){
        Integer i = announcementMapper.insertAn(Content, Title, TID);

        model.addAttribute("alert", "发布成功！请刷新查看！");
        return "super/alert";
    }

}
