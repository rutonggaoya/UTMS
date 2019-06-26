package com.ecust.utms.controller.Administrator;

import com.alibaba.fastjson.JSONObject;
import com.ecust.utms.mapper.AdministratorMapper;
import com.ecust.utms.mapper.AnnouncementMapper;
import com.ecust.utms.mapper.SelectSubjectMapper;
import com.ecust.utms.mapper.SubjectMapper;
import com.ecust.utms.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdministratorMapper administratorMapper;
    @Autowired
    SubjectMapper subjectMapper;
    @Autowired
    AnnouncementMapper announcementMapper;
    @Autowired
    SelectSubjectMapper selectSubjectMapper;

    @GetMapping("/admin/users")
    public String toPersonalCentre(HttpSession session){
        Administrator user = (Administrator) session.getAttribute("loginuser");
        Administrator admin = administratorMapper.getAd(user.getTID());
        session.setAttribute("loginuser",admin);
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
        model.addAttribute("anns",all);
        return "super/supermessage";
    }

    @GetMapping("/admin/superInfos")
    public String toSuperInfoPage(Model model, HttpSession session){

        return "super/superUserStu";
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
