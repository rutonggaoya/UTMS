package com.ecust.utms.controller.Student;

import com.ecust.utms.mapper.*;
import com.ecust.utms.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    SubjectMapper subjectMapper;

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    ThesisMapper thesisMapper;

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    AnnouncementMapper announcementMapper;

    @Autowired
    AttachmentMapper attachmentMapper;

    @Autowired
    AnswerMapper answerMapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/message")
    public String showMessagePage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        Student student = (Student)session.getAttribute("loginuser");
        String sid = student.getSID();
        logger.trace("--->Student: " + sid);
        map.put("loginuser", student);

        List<Announcement> announcements = announcementMapper.getAllAn();
        for (Announcement announcement : announcements){
            List<Attachment> attachs = attachmentMapper.getAtByAID(announcement.getAID());
            announcement.setAttachments(attachs);
        }
        map.put("anns",announcements);
        return "Student/message";
    }

    @GetMapping("/messageInfo")
    public String toMessageInfoPage(@RequestParam(value = "AID") String AID, Model model, HttpSession session){
        Announcement announcement = announcementMapper.getAn(Integer.valueOf(AID));
        List<Attachment> attachs = attachmentMapper.getAtByAID(announcement.getAID());
        announcement.setAttachments(attachs);
        model.addAttribute("announcement", announcement);
        return "Student/messageInfo";
    }

    @GetMapping("/topic")
    public String showTopicPage(@RequestParam(value = "DeptID", required = false) Integer DeptID, Map<String,Object> map, HttpSession session, HttpServletRequest request){
        Student student = (Student)session.getAttribute("loginuser");
        String sid = student.getSID();
        logger.trace("--->Student: " + sid);
        map.put("loginuser", student);

        // 获取课题列表（指定or不指定学院）
        List<Subject> allSub;
        if (DeptID==null) {
            allSub = subjectMapper.getAllSub();
            map.put("currentDept", "所有");
        }
        else {
            allSub = subjectMapper.getSubListByDept(DeptID.toString());
            Department department = departmentMapper.getDept(DeptID);
            map.put("currentDept", department.getName());
        }
        map.put("allSub", allSub);

        // 获取学院列表
        List<Department> allDept = departmentMapper.getAllDept();
        map.put("allDept", allDept);

        // 获取'我的课题'及指导老师
        Subject mySub = subjectMapper.getStuSub(sid);
        if(mySub != null)
            map.put("mySub", mySub);
        else {
            mySub = new Subject(0, "暂未选定", "暂未选定", -1, -1, -1, "暂未选定");
            map.put("mySub", mySub);
        }
        Teacher teacher = teacherMapper.getTea(mySub.getTID());
        if(teacher != null)
            map.put("myTeacher", teacher);
        else {
            teacher = new Teacher();
            teacher.setName("暂未选定");
            map.put("myTeacher", teacher);
        }
        return "Student/topic";
    }

    @GetMapping("/person")
    public String showPersonPage(Map<String,Object> map, HttpSession session, HttpServletRequest request,Model model){
        Student student = (Student)session.getAttribute("loginuser");
        String sid = student.getSID();
        logger.trace("--->Student: " + sid);
        map.put("loginuser", student);

        // 查询个人信息 + 课题信息
        StudentPersonalPageData person = studentMapper.getSPPD(sid);
        if (person==null){
            person = new StudentPersonalPageData(student.getSID(), student.getName(), student.getGender(), student.getMajor(),
                    student.getDeptID(), student.getPasswd(), student.getTel(), student.getEmail(),
                    "N/A", "N/A","N/A","N/A");
        }
        map.put("person", person);
        return "Student/person";
    }

    @GetMapping("/question")
    public String showQuestionPage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        Student student = (Student)session.getAttribute("loginuser");
        String sid = student.getSID();
        logger.trace("--->Student: " + sid);
        map.put("loginuser", student);

        // 查询我的所有回答
        List<AnswerIntroData> myanss = questionMapper.getMyAnswerBySID(sid);
        map.put("myanss", myanss);

        // 查询我的所有提问
        List<Question> myQuestions = questionMapper.getMyQuestionBySID(sid);
        map.put("myQuestions", myQuestions);

        return "Student/question";
    }

    @GetMapping("/questionDetail")
    public String showQuestionDetailPage(Map<String,Object> map, HttpSession session, @RequestParam("QID") String QID){
        List<Answer> answers = answerMapper.getAnsByQID(QID);
        map.put("answers", answers);

        Question question = questionMapper.getQuestionByQID(QID);
        map.put("question", question);
        return "Student/questionDetail";
    }

    @ResponseBody
    @GetMapping(value = "/raiseQuestion", produces = "application/json;charset=UTF-8")
    public String raiseQuestion(Map<String,Object> map, HttpSession session, @RequestParam("QuestionContent") String QuestionContent,
                                @RequestParam("QuestionDesc") String QuestionDesc, @RequestParam("SID") String SID) throws JSONException{

        Boolean success = questionMapper.insertQuestion(QuestionContent, QuestionDesc, SID);
        if (!success)
            return new JSONObject(){{
                put("status", "failed");
            }}.toString();
        else
            return new JSONObject(){{
                put("status", "ok");
            }}.toString();
    }


    @GetMapping("/dissertation")
    public String showDissertationPage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        Student student = (Student)session.getAttribute("loginuser");
        String sid = student.getSID();
        logger.trace("--->Student: " + sid);
        map.put("loginuser", student);

        // 查询已选中的课题
        Subject mySub = subjectMapper.getStuSub(sid);
        if(mySub != null)
            map.put("mySub", mySub);
        else {
            mySub = new Subject(0, "暂未选定", "暂未选定", -1, -1, -1, "暂未选定");
            map.put("mySub", mySub);
        }

        // 查询已上传的文档列表
        List<Thesis> thesisList = thesisMapper.getThesisListByStuID(sid);
        map.put("myThesisList", thesisList);

        // 查询是否上传了最终版
        String ThesisID = thesisMapper.checkFinalSubmit(sid);
        if(ThesisID == null){
            map.put("FinalThesisID",0);
        } else{
            map.put("FinalThesisID", ThesisID);
        }

        return "Student/dissertation";
    }

    @GetMapping("/StudentEditInfo")
    public String showStudentEditInfoPage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        Student student = (Student)session.getAttribute("loginuser");
        String sid = student.getSID();
        logger.trace("--->Student: " + sid);
        map.put("loginuser", student);

        // 查询个人信息 + 课题信息
        StudentPersonalPageData person = studentMapper.getStudentPersonalPageData(sid);
        if (person==null){
            person = new StudentPersonalPageData(student.getSID(), student.getName(), student.getGender(), student.getMajor(),
                    student.getDeptID(), student.getPasswd(), student.getTel(), student.getEmail(),
                    "N/A", "N/A","N/A","N/A");
        }
        map.put("person", person);
        return "Student/StudentEditInfo";
    }

    @ResponseBody
    @PostMapping(value = "/chooseSub", produces = "application/json;charset=UTF-8")
    public String chooseSubject(@RequestParam("choices") String choices,
                                @RequestParam("SID") String SID,
                                Map<String, Object> map, HttpSession session,
                                HttpServletRequest request) throws JSONException {

        JSONObject res = new JSONObject();

        for( String str : choices.split("&") ) {
            String[] split = str.split("=");
            String SubjID = split[0];
            String VOrder = split[1];
            subjectMapper.setSubChoice(SubjID, VOrder, SID);
        }

        res.put("status", "ok");

        return res.toString();
    }

    @PostMapping("/evaluateteacher")
    public String evaluateteacher(EvaluateTeacher et){
        System.out.println(et.toString());
        studentMapper.insertETBbySID(et);
        return "redirect:/Student/person";
    }

}
