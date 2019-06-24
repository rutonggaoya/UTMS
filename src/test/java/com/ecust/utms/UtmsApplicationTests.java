package com.ecust.utms;

import com.ecust.utms.mapper.AdministratorMapper;
import com.ecust.utms.mapper.TeacherMapper;
import com.ecust.utms.mapper.ThesisMapper;
import com.ecust.utms.model.Administrator;
import com.ecust.utms.model.Teacher;
import com.ecust.utms.model.Thesis;
import com.ecust.utms.model.ThesisPageData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
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
        List<ThesisPageData> list1 = thesisMapper.getAllTPD("510100003");
        for(ThesisPageData t:list1){
            System.out.println(t.toString());
        }
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
