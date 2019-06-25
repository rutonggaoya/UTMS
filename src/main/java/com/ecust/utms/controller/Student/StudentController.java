package com.ecust.utms.controller.Student;

import com.ecust.utms.mapper.*;
import com.ecust.utms.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/message")
    public String showMessagePage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        Student student = (Student)session.getAttribute("loginuser");
        String sid = student.getSID();
        logger.trace("--->Student: " + sid);
        map.put("loginuser", student);


        return "Student/message";
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
        map.put("mySub", mySub);
        Teacher teacher = teacherMapper.getTea(mySub.getTID());
        map.put("myTeacher", teacher);
        return "Student/topic";
    }

    @GetMapping("/person")
    public String showPersonPage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        Student student = (Student)session.getAttribute("loginuser");
        String sid = student.getSID();
        logger.trace("--->Student: " + sid);
        map.put("loginuser", student);

        // 查询个人信息 + 课题信息
        StudentPersonalPageData person = studentMapper.getStudentPersonalPageData(sid);
        if (person==null){
            person = new StudentPersonalPageData(student.getSID(), student.getName(), student.getGender(), student.getMajor(),
                    student.getDeptID().toString(), student.getPasswd(), student.getTel(), student.getEmail(),
                    "N/A", "N/A","N/A","N/A", "N/A");
        }
        map.put("person", person);
        return "Student/person";
    }

    @GetMapping("/question")
    public String showQuestionPage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        String loginuser = "" + session.getAttribute("loginuser");
        logger.trace("--->Student: " + loginuser);
        map.put("loginuser", loginuser);


        return "Student/question";
    }

    @GetMapping("/dissertation")
    public String showDissertationPage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        Student student = (Student)session.getAttribute("loginuser");
        String sid = student.getSID();
        logger.trace("--->Student: " + sid);
        map.put("loginuser", student);

        Subject mySub = subjectMapper.getStuSub(sid);
        map.put("mySub", mySub);

        List<Thesis> thesisList = thesisMapper.getThesisListByStuID(sid);
        map.put("myThesisList", thesisList);

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
                    student.getDeptID().toString(), student.getPasswd(), student.getTel(), student.getEmail(),
                    "N/A", "N/A","N/A","N/A", "N/A");
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

}
