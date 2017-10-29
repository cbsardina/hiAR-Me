package com.arproject.arproject.controller;


import com.arproject.arproject.model.Uzer;
import com.arproject.arproject.model.UzerAuth;
import com.arproject.arproject.service.UzerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;

@Controller
public class UzerController {

    @Autowired
    UzerService uzerService;

/** * * * * * * * *
     Login, '/' redirect, & LogOut
 */
    @GetMapping("/Login")
    public String login() { return "login"; }

    @GetMapping("/")
    public String redirLogin() { return "redirect:/Login"; }

    @GetMapping("/loggedout")
    public String redirLogout() { return "redirect:/Login"; }

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
                    uzerService.addUzer(newUzer);

            return "login";
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
     Update User Update/Add Items
 */
    @GetMapping("/updateUserInfo/{userId}")
    public String getUserInfoUpdate(@PathVariable("userId") int userId, Model model) {
        Uzer uzer = uzerService.getUzerById(userId);
            model.addAttribute("uzer", uzer);
        return "updateInfo";
    }

    @PostMapping("/updateUserInfo/{userId}")
    public String updateUserInfo(@PathVariable("userId") int userId,
                                 @RequestParam("firstLastName") String firstLastName,
                                 @RequestParam("userEmail") String userEmail,
                                 @RequestParam("itemName") String itemName,
                                 @RequestParam("itemDescription") String itemDescription,
                                 @RequestParam("fileUpload") File[] fileUpload) {
        Uzer uzer = uzerService.getUzerById(userId);
            uzer.setFirstLastName(firstLastName);
            uzer.setUserEmail(userEmail);
                uzerService.updateUzer(uzer);
        return "redirect:/userInfo/" + userId;
    }

    @GetMapping("/updateUserItems/{userId}")
    public String getUserItemsUpdate(@PathVariable("userId") int userId, Model model) {
        Uzer uzer = uzerService.getUzerById(userId);
        //TODO: have to add iteration of all items per user
            model.addAttribute("uzer", uzer);
        return "updateItems";
    }

    @PostMapping("/updateUserInfo/{userId}")
    public String updateUserItems(@PathVariable("userId") int userId,
                                 @RequestParam("itemName") String itemName,
                                 @RequestParam("itemDescription") String itemDescription,
                                 @RequestParam("fileUpload") File[] fileUpload) {
        //TODO: FTP and setFileName for each item.

        return "redirect:/userInfo/" + userId;
    }


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