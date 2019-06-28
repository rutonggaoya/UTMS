package com.ecust.utms.controller.Administrator;

import com.alibaba.fastjson.JSONObject;
import com.ecust.utms.mapper.*;
import com.ecust.utms.model.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
import java.util.LinkedList;
import java.util.List;

@Controller
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
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ThesisMapper thesisMapper;

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
    @ResponseBody
    @GetMapping("/admin/topic")
    public List<SelectSubject> toTopicDetail(@RequestParam("SubjID") Integer SubjID,HttpSession session){
        List<SelectSubject> selectSubjects = selectSubjectMapper.getSelectSubBySubjID(SubjID);
        for (SelectSubject s : selectSubjects) {
            s.setStatusName();
            System.out.println(s.toString());
        }
        return selectSubjects;
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

    @GetMapping("/admin/users")
    public String toSuperInfoPage(Model model, HttpSession session){
        return "super/superUserStu";
    }

    @PostMapping("/admin/announce")
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

    @GetMapping("/admin/studentInfo")
    public String toStudentInfoPage(@RequestParam("SID") String SID, Model model){
        Student student = studentMapper.getStu(SID);
        model.addAttribute("student", student);
        return "super/studentInfo";
    }

    @ResponseBody
    @GetMapping("/admin/getStudentsSubject")
    public List<StudentSubject> getStudentsSubject(){
        List<StudentSubject> res = new LinkedList<>();
        List<Student> allStudent = studentMapper.getAllStudent();
        for (int i = 0; i <allStudent.size(); i++) {
            // 获取学生基本信息
            Student student = allStudent.get(i);
            StudentSubject ss = new StudentSubject();
            ss.setSID(student.getSID());
            ss.setName(student.getName());

            // 获取学生课题信息
            Subject subject = subjectMapper.getStuSub(student.getSID());
            if(subject != null)
                ss.setSubjName(subject.getName());
            else
                ss.setSubjName("还未选择");

            // 获取学生论文信息
            String FinalThesisID = thesisMapper.checkFinalSubmit(student.getSID());
            if(FinalThesisID!=null){
                String SimilarityRate = thesisMapper.getSimilarityRateByThesisID(FinalThesisID);
                ss.setSimilarityRate(SimilarityRate);

                String EGrade = thesisMapper.getEGradeByThesisID(FinalThesisID);
                if(EGrade!=null)
                    ss.setGrade(EGrade);
                else
                    ss.setGrade("还未打分");
            } else {
                ss.setGrade("未提交论文");
                ss.setSimilarityRate("未提交论文");
            }
            res.add(ss);
        }
        return res;
    }

    @ResponseBody
    @GetMapping(value = "/admin/setSelectSubject")
    public String setSelectSubject(@RequestParam("SID") String SID,
                                   @RequestParam("SubjID") String SubjID,
                                   @RequestParam("Status") String StatusStr){
        String Status = "0";
        if("已允许".equals(StatusStr))
            Status = "1";
        if("已拒绝".equals(StatusStr))
            Status = "2";
        if("未审核".equals(StatusStr))
            Status = "0";

        selectSubjectMapper.setSelectSubjectStatus(SubjID, SID, Status);

        return new JSONObject(){{
            put("status", "ok");
        }}.toString();
    }

    @ResponseBody
    @GetMapping(value = "/admin/setScore")
    public String setScore(@RequestParam("SID") String SID, @RequestParam("EGrade") String EGrade){
        JSONObject res = new JSONObject();
        String ThesisID = thesisMapper.checkFinalSubmit(SID);
        Boolean success = thesisMapper.setScore(EGrade, ThesisID);
        if(!success)
            res.put("status", "failed");
        else
            res.put("status", "ok");
        return res.toString();
    }


}
