package com.arproject.arproject.controller;

import com.arproject.arproject.model.MailObject;
import com.arproject.arproject.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MailController {

    @Autowired
    public EmailServiceImpl emailService;

    @Autowired
    public SimpleMailMessage template;

    private static final Map<String, Map<String, String>> labels;

    static {
        labels = new HashMap<>();

        //simple email
        Map<String, String> props = new HashMap<>();
        props.put("headerText", "Send Simple Email");
        props.put("messageLabel", "Message");
        props.put("additionalInfo", "");
        labels.put("send", props);
    }

    @GetMapping("/mail/home")
    public String mailHome(){
        return "mailHome";
    }

    @PostMapping("/mail/sendSimple")
    public String sendSimpleEmail(Model model,
                                  @ModelAttribute("mailObject") @Valid MailObject mailObject) {
        try {
            emailService.sendSimpleMessage(mailObject.getTo(), mailObject.getSubject(), mailObject.getText());
            return "emailSuccess";
        } catch (Exception ex) {
            return "Error Sending Email v1: " + ex;
        }
    }


    //TODO: BUILD EMAIL WITH THIS:
    @Autowired
    private JavaMailSender sender;

    @RequestMapping("/simpleemail")
    @ResponseBody
    String home() {
        try {
            sendEmail();
            return "Email Sent!";
        } catch (Exception ex) {
            return "Error Sending Email v2: " + ex;
        }
    }

    private void sendEmail() throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo("cbsardina@gmail.com");
        helper.setText("Hope this works");
        helper.setSubject("Second Method");

        sender.send(message);
    }

}
