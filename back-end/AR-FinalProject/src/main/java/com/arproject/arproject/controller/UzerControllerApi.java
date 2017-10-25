package com.arproject.arproject.controller;

import com.arproject.arproject.model.Uzer;
import com.arproject.arproject.service.UzerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class UzerControllerApi {

    @Autowired
    UzerService uzerService;

  // --- JSON to Java Obj ---
    private ObjectMapper objMap = new ObjectMapper();

  // *** GET USER ***
    @GetMapping("/api/get_uzer/{userId}")
    public Uzer getArUser(@PathVariable("userId") int userId) {
        return uzerService.getUzerById(userId);
    }


  // *** ADD USER ***
    @PostMapping("/api/add_user")
    public Uzer addArUser(@RequestBody String json) throws IOException {
        Uzer newUzer = objMap.readValue(json, Uzer.class);
        return uzerService.addUzer(newUzer);
    }

  // *** EDIT USER ***
    @PutMapping("/api/update_user/{userId}")
    public Uzer updateArUser(@PathVariable("userId") int userId, @RequestBody String json) throws IOException {
        Uzer updatesToUser = objMap.readValue(json, Uzer.class);
        updatesToUser.setId(userId);
        return uzerService.updateUzer(updatesToUser);
    }

//    @PostMapping("/api/update_user/{userId}/add_object")
//    public Uzer updateArUserAddObject(@PathVariable("userId") int userId, @RequestBody String json) throws IOException {
//        UzerItem newArUserObject = objMap.readValue(json, UzerItem.class);
//        Uzer foundArUser = uzerService.getUzerById(userId);
//            newArUserObject.setUzer(foundArUser);
//        return uzerService.addNewObject(newArUserObject);
//    }

  // *** DELETE USER ***
//    @DeleteMapping("/api/delete_user/{userId}")
//    public String deleteOneUser(@PathVariable("userId") int userId) {
//        uzerService.deleteArUser(userId);
//        return "USER DELETED";
//    }

  // *** DELETE ALL USERS - FOR DEVELOPMENT ONLY ***
//    @DeleteMapping("/api/delete_all_users/{deleteCode}")
//    public String deleteAllUsers(@PathVariable("deleteCode") Integer deleteCode) {
//        if (deleteCode.equals(11022017)) {
//            uzerService.deleteAllArUsers();
//        }
//        return "DATABASE DELETED";
//    }

//     *** EXCEPTION HANDLER ***
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exceptionHandler(Exception e) {
        System.out.println("\n\n### " + e);
        e.printStackTrace();
        return  e.getMessage();
    }

}
