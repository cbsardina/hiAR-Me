package com.arproject.arproject.web.controller;

import com.arproject.arproject.business.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class MainController {

    private static final String EDITABLE_TEMPLATE = "mail/editablehtml/email-editable.html";

    @Autowired
    private EmailService emailService;

    /* Home page. */
    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    /* Plain text email. */
    @RequestMapping(value = "/text.html", method = RequestMethod.GET)
    public String text() {
        return "text";
    }

    /* Simple HTML email. */
    @RequestMapping(value = "/simple.html", method = RequestMethod.GET)
    public String simple() {
        return "simple";
    }

    /* HTML email with attachment. */
    @RequestMapping(value = "/attachment.html", method = RequestMethod.GET)
    public String attachment() {
        return "attachment";
    }

    /* HTML email with inline image. */
    @RequestMapping(value = "/inline.html", method = RequestMethod.GET)
    public String inline() {
        return "inline";
    }

    /* Editable HTML email. */
    @RequestMapping(value = "/editable.html", method = RequestMethod.GET)
    public String editable(final Model model) throws IOException {
        model.addAttribute("baseTemplate", this.emailService.getEditableMailTemplate());
        return "editable";
    }

    /* Sending confirmation page. */
    @RequestMapping(value = "/sent.html", method = RequestMethod.GET)
    public String sent() {
        return "sent";
    }

}

