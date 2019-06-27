package com.ecust.utms;

import com.ecust.utms.mapper.*;
import com.ecust.utms.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtmsApplicationTests {

    @Autowired
    AdministratorMapper administratorMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    ThesisMapper thesisMapper;
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void contextLoads() {
        //测试AdministratorMapper
//        List<Administrator> list = administratorMapper.getAllAd();
//        for (Administrator ad:list
//        ) {
//            System.out.println(ad.toString());
//        }
        //测试TeacherMapper
//        Teacher tea = teacherMapper.getTea("111");
//        tea.setName("开心");
//        teacherMapper.updateTea(tea);
//        System.out.println(teacherMapper.getTea("111").toString());
        //测试ThesisMapper
//        List<ThesisPageData> list1 = thesisMapper.getAllTPD("510100003");
//        for(ThesisPageData t:list1){
//            System.out.println(t.toString());
//        }
//        //测试QuestionMapper
//        List<AnswerIntroData> list2 = questionMapper.getMyAnswerByTID("510100003");
//        for(AnswerIntroData a:list2){
//            System.out.println(a.toString());
//        }
        StudentPersonalPageData sppd = studentMapper.getSPPD("110161870");
        System.out.println(sppd.toString());
    }

//    Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Test
//    public void contextLoads() {
////        System.out.println();
//        logger.trace("这是trace日志...");
//        logger.debug("这是debug日志...");
//        logger.info("这是info日志...");
//        logger.warn("这是warn日志...");
//        logger.error("这是error日志...");
//    }

}
