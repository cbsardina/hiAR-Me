package com.arproject.arproject.controller;


import com.arproject.arproject.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Locale;

@Controller
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam("visitorName") String visitorName, @RequestParam("visitorEmail") String visitorEmail, final Locale locale) throws MessagingException, IOException {
        this.emailService.sendEditableEmail(visitorName, visitorEmail, locale);
        return "redirect:/sent.html";
    }

    @GetMapping("/editable.html")
    public String editableEmail(final Model model) throws IOException {
        model.addAttribute("baseTemplate", this.emailService.getEditableMailTemplate());
        return "editable";
    }

    @GetMapping("/sent.html")
    public String emailSent() { return "sent"};
}
