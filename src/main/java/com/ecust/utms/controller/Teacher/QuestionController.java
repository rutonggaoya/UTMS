package com.ecust.utms.controller.Teacher;

import com.ecust.utms.mapper.QuestionMapper;
import com.ecust.utms.model.AnswerIntroData;
import com.ecust.utms.model.Question;
import com.ecust.utms.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class QuestionController {

    @Autowired
    QuestionMapper questionMapper;

//    @GetMapping("/questions")
//    public String toQuePage(Model model){
//        List<Question> allQue = questionMapper.getAllQue();
//        model.addAttribute("ques",allQue);
//        return "Teacher/Teacherquestion";
//    }

    @GetMapping("/questions")
    public String toMyAnsPage(Model model, HttpSession session){
        Teacher user = (Teacher)session.getAttribute("loginuser");
        List<Question> allQue = questionMapper.getAllQue();
        model.addAttribute("ques",allQue);
        List<AnswerIntroData> all = questionMapper.getMyAnswerByTID(user.getTID());
        model.addAttribute("myanss",all);
        return "Teacher/Teacherquestion";
    }
}
