package com.ecust.utms.controller.Student;

import com.ecust.utms.mapper.ThesisMapper;
import com.ecust.utms.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Map;

@Controller
@RequestMapping("/Student/Files")
public class FileController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ThesisMapper thesisMapper;

    FileService fileService = new FileService();

    @ResponseBody
    @DeleteMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public String deleteStuFile(@RequestParam(value = "FilePath") String FilePath) throws JSONException {
        logger.info("=====FilePath: " + FilePath);

        // 在数据库中删除记录
        thesisMapper.deleteFileByPath(FilePath);

        // 删除文件
        JSONObject res = new JSONObject();
        if (!fileService.deleteFile(FilePath))
            res.put("status", "failed");
        else
            res.put("status", "ok");

        return res.toString();
    }





}
