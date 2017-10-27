package com.arproject.arproject.controller;


import com.arproject.arproject.service.UzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UzerController {

    @Autowired
    UzerService uzerService;

    @GetMapping("/Login")
    public String login() { return "login"; }

    @GetMapping
    public String redirLogin() { return "redirect:/Login"; }

    @GetMapping("/SignUp")
    public String signUp() {return "signUp"; }



}
