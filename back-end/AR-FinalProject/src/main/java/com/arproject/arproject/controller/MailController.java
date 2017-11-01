package com.arproject.arproject.controller;

import com.arproject.arproject.model.MailObject;
import com.arproject.arproject.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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
                                  @ModelAttribute("mailObject") @Valid MailObject mailObject, Errors err) {
        if (err.hasErrors()) {
            return "emailError";
        }
        emailService.sendSimpleMessage(mailObject.getTo(), mailObject.getSubject(), mailObject.getText());
        return "emailSuccess";
    }

}
