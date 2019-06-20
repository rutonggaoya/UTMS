package com.ecust.utms;

import com.ecust.utms.mapper.AdministratorMapper;
import com.ecust.utms.model.Administrator;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Test
    public void contextLoads() {
        //测试AdministratorMapper
        List<Administrator> list = administratorMapper.getAllAd();
        for (Administrator ad:list
        ) {
            System.out.println(ad.toString());
        }
    }

}
