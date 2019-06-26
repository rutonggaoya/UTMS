package com.ecust.utms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class FileService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${file.upload-folder}")
    private String FILE_FOLDER;

    public Boolean deleteFile(String FilePath){
        FilePath = FILE_FOLDER + FilePath;
        try {
            File file = new File(FilePath);
            logger.info("=====Deleting:" + file.getAbsoluteFile());
            return file.delete();
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return false;
    }


    public String downloadFile(String path, HttpServletResponse response){
        if (path != null) {
            path = FILE_FOLDER + path;
            File file = new File(path);
            String[] split = path.split("/");
            String fileName = split[split.length - 1];

            if (file.exists()) {
                logger.info("=====Downloading:" + file.getAbsoluteFile());
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" +  fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }


    public String uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            return "文件为空";
        }
        logger.info("=====Uploading:" + file.getOriginalFilename());
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        String filePath = FILE_FOLDER + "userfiles/";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

}
