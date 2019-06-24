package com.ecust.utms.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class FileService {
    Logger logger = LoggerFactory.getLogger(getClass());

    public Boolean deleteFile(String FilePath){
        FilePath = "src/main/resources/static/" + FilePath;
        try {
            File file = new File(FilePath);
            logger.info("=====Deleting:" + file.getAbsoluteFile());
            return file.delete();
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return false;
    }
}
