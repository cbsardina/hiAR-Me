package com.arproject.arproject.controller;


import com.arproject.arproject.service.ArUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArUserController {

    @Autowired
    ArUserService arUserService;

    @GetMapping("/add_user")
    public String addUser() { return "addUser"; }


}
