package com.ecust.utms.controller.Administrator;

import com.alibaba.fastjson.JSONObject;
import com.ecust.utms.mapper.AdministratorMapper;
import com.ecust.utms.mapper.AnnouncementMapper;
import com.ecust.utms.mapper.AttachmentMapper;
import com.ecust.utms.mapper.SelectSubjectMapper;
import com.ecust.utms.mapper.SubjectMapper;
import com.ecust.utms.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

@Controller
//@RequestMapping("/admin")
public class AdminController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AdministratorMapper administratorMapper;
    @Autowired
    SubjectMapper subjectMapper;
    @Autowired
    AnnouncementMapper announcementMapper;
    @Autowired
    SelectSubjectMapper selectSubjectMapper;
    @Autowired
    AttachmentMapper attachmentMapper;

    @GetMapping("/admin/superInfo")
    public String toPersonalCentre(Model model, HttpSession session){
//        Administrator user = (Administrator) session.getAttribute("loginuser");
//        Administrator admin = administratorMapper.getAd(user.getTID());
//        model.addAttribute("admin", admin);
        return "super/superInfo";
    }

    @ResponseBody
    @RequestMapping(value="/topics.do" ,method = RequestMethod.GET)
    public String getTopicJSON(Model model){
//        List<SelectSubject> SSall =
        List<Subject> all = subjectMapper.getAllSubAndTeaName();
        for (Subject s:all){
            s.setStatusName();
        }

        return JSONObject.toJSONString(all);
    }

    @GetMapping("/admin/topics")
    public String toTopicPage(){
        return "super/superTopic";
    }

//    @GetMapping("/admin/topic/{SubjID}")
    @GetMapping("/admin/topic")
    public String toTopicDetail(@RequestParam("SubjID") Integer SubjID,HttpSession session){
        List<SelectSubject> selectSubjects = selectSubjectMapper.getSelectSubBySubjID(SubjID);
        for (SelectSubject s:selectSubjects
             ) {
            s.setStatusName();
            System.out.println(s.toString());
        }
//        session.setAttribute("ssubs",selectSubjects);

        JSONObject json = new JSONObject();
        json.put("ssubs",selectSubjects);
        return json.toJSONString();
    }

    @GetMapping("/admin/messages")
    public String toMessagePage(Model model, HttpSession session){
        List<Announcement> all = announcementMapper.getAllAn();
        for (Announcement announcement : all){
            List<Attachment> attachs = attachmentMapper.getAtByAID(announcement.getAID());
            announcement.setAttachments(attachs);
        }
        model.addAttribute("anns",all);
        return "super/supermessage";
    }

    @GetMapping("/admin/messageInfo")
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

    @GetMapping("/admin/UserStu")
    public String toUserStuPage(){

        return "super/superUserStu";
    }

    @GetMapping("/admin/UserTea")
    public String toUserTeaPage(){

        return "super/superUserTea";
    }

}
