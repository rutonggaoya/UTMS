package com.ecust.utms.controller;

import com.ecust.utms.mapper.AdministratorMapper;
import com.ecust.utms.model.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//标识包的测试类 无用
@RestController
public class TestController {

    @Autowired
    AdministratorMapper administratorMapper;

    @GetMapping("/ads")
    public List<Administrator> listAd(){
        return administratorMapper.getAllAd();
    }

    @GetMapping("/ad/{TID}")
    public Administrator getAd(@PathVariable("TID") String TID){
        return administratorMapper.getAd(TID);
    }

    @GetMapping("/ad")
    public Administrator insertAd(Administrator ad){
        administratorMapper.insertAd(ad);
        return ad;
    }

//    @DeleteMapping("/deletead/{TID}")
    @RequestMapping(value = "/deletead/{TID}")
    public String deleteEmp(@PathVariable("TID") String TID){
        administratorMapper.deleteAd(TID);
        return TID;
    }

//    @GetMapping("/updatead")
//    public Administrator updateAd(Administrator ad){
//        administratorMapper.updateAd(ad);
//        return ad;
//    }



}
