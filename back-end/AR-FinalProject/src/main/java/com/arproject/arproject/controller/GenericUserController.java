package com.arproject.arproject.controller;


import com.arproject.arproject.service.GenericUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GenericUserController {

    @Autowired
    GenericUserService genericUserService;

}
