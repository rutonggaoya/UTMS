package com.ecust.utms.controller.Teacher;

import com.ecust.utms.mapper.AnnouncementMapper;
import com.ecust.utms.mapper.AttachmentMapper;
import com.ecust.utms.model.Announcement;
import com.ecust.utms.model.Attachment;
import com.ecust.utms.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class MessageController {

    @Autowired
    AnnouncementMapper announcementMapper;

    @Autowired
    AttachmentMapper attachmentMapper;

    @GetMapping("/messages")
    public String showMessagePage(Map<String,Object> map, HttpSession session, HttpServletRequest request){
        List<Announcement> announcements = announcementMapper.getAllAn();
        for (Announcement announcement : announcements){
            List<Attachment> attachs = attachmentMapper.getAtByAID(announcement.getAID());
            announcement.setAttachments(attachs);
        }
        map.put("anns",announcements);
        return "Teacher/Teachermessage";
    }

    @GetMapping("/messageInfo")
    public String toMessageInfoPage(@RequestParam(value = "AID") String AID, Model model, HttpSession session){
        Announcement announcement = announcementMapper.getAn(Integer.valueOf(AID));
        List<Attachment> attachs = attachmentMapper.getAtByAID(announcement.getAID());
        announcement.setAttachments(attachs);
        model.addAttribute("announcement", announcement);
        return "Teacher/messageInfo";
    }
}
