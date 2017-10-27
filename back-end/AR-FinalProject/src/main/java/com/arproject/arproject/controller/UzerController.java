package com.arproject.arproject.controller;


import com.arproject.arproject.model.Uzer;
import com.arproject.arproject.model.UzerAuth;
import com.arproject.arproject.service.UzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class UzerController {

    @Autowired
    UzerService uzerService;

    @GetMapping("/Login")
    public String login() { return "login"; }

    @GetMapping
    public String redirLogin() { return "redirect:/Login"; }

/** * * * * * * * *
     Create User
 */
    @GetMapping("/SignUp")
    public String signUp() {return "signUp"; }

    @PostMapping("/SignUp")
    public String addUzer(@RequestParam(value = "firstLastName") String firstLastName,
                        @RequestParam(value = "userEmail") String userEmail,
                        @RequestParam(value = "userPass") String userPass,
                        @RequestParam(value = "passCompare") String passCompare) {
            Uzer newUzer = new Uzer();
                newUzer.setUserEmail(userEmail);
                newUzer.setUserPass(userPass);
                newUzer.setUserEnabled(true);
                newUzer.setUserAuth(UzerAuth.ROLE_USER);
                newUzer.setFirstLastName(firstLastName);
            newUzer = uzerService.addUzer(newUzer);
            int userId = newUzer.getId();

            return "userInfo/" + userId;
    }

/** * * * * * * * *
     User Info View (not editable)
 */
    @GetMapping("/userInfo/{userId}")
    public String getUzerInfoPage(@PathVariable("userId") int userId, Model model) {
        Uzer uzer = uzerService.getUzerById(userId);
            model.addAttribute("uzer", uzer);
        return "userInfo";
    }

/** * * * * * * * *
     Update User/Add Items
 */
    @GetMapping("/updateUserInfo/{userId}")
    public String getUserInfoUpdate(@PathVariable("userId") int userId, Model model) {
        Uzer uzer = uzerService.getUzerById(userId);
            model.addAttribute("uzer", uzer);
        return "updateInfo";
    }

    @PostMapping("/updateUserInfo/{userId}")



    //TODO: ADD UPDATE/ADD ITEMS ROUTES

/** * * * * * * * *
     Exception Handling
 */
    @ExceptionHandler(value = Exception.class)
    public String handleDefaultErrors(final Exception exception, Model model) {
        System.out.println(exception);
        model.addAttribute("message", exception.getMessage());
        return "error_message";
    }
}