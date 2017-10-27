package com.arproject.arproject.controller;

import com.arproject.arproject.model.Uzer;
import com.arproject.arproject.model.UzerItem;
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

/** * * * * * * * *
    JSON to Java Obj
 */
    private ObjectMapper objMap = new ObjectMapper();

/** * * * * * * * *
    Get User
 */
    @GetMapping("/api/user/{userId}")
    public Uzer getUzer(@PathVariable("userId") int userId) {
        return uzerService.getUzerById(userId);
    }

/** * * * * * * * *
    Add User
 */
    @PostMapping("/api/user/add_user")
    public Uzer addUzer(@RequestBody String json) throws IOException {
        Uzer newUzer = objMap.readValue(json, Uzer.class);
        return uzerService.addUzer(newUzer);
    }
/** * * * * * * * *
    Edit/Update User
 */
    @PutMapping("/api/user/{userId}/update_user")
    public Uzer updateUzer(@PathVariable("userId") int userId, @RequestBody String json) throws IOException {
        Uzer uzer= objMap.readValue(json, Uzer.class);
        uzer.setId(userId);
        return uzerService.updateUzer(uzer);
    }

/** * * * * * * * *
    Delete User
 */
    @DeleteMapping("/api/user/{userId}")
    public String deleteOneUser(@PathVariable("userId") int userId) throws IOException {
        Uzer uzer = uzerService.getUzerById(userId);
        uzerService.deleteUzer(userId);
        return "User: " + uzer.getUserName() + " deleted.";
    }

/** * * * * * * * *
    Add User Item
 */
    @PostMapping("/api/user/{userId}/add_item")
    public UzerItem addItem(@PathVariable("userId") int userId, @RequestBody String json) throws IOException {
        UzerItem uzerItem = objMap.readValue(json, UzerItem.class);
        Uzer uzer = uzerService.getUzerById(userId);
            uzerItem.setUzer(uzer);
        uzerService.addItem(uzerItem);

        return uzerItem;
    }

/** * * * * * * * *
    Delete User Item
 */
    @DeleteMapping("/api/user/{userId}/item/{itemId}/delete_item")
    public String deleteItem(@PathVariable("userId") int userId, @PathVariable("itemId") int itemId) {
            uzerService.deleteItem(userId, itemId);
        return "Item Deleted";
    }

/** * * * * * * * *
     DeleteAll Users & Items for dev only
 */

    @DeleteMapping("/api/delete_all_items/{deleteCode}")
    public String deleteAllItems(@PathVariable("deleteCode") Integer deleteCode) {
        if (deleteCode.equals(64829504)) {
            uzerService.deleteAllItems();
            return "ITEMS DATABASE DELETED";
        }
            return "Incorrect delete code";
    }

    @DeleteMapping("/api/delete_all_users/{deleteCode}")
    public String deleteAllUsers(@PathVariable("deleteCode") Integer deleteCode) {
        if (deleteCode.equals(11022017)) {
            uzerService.deleteAllUsers();
            return "USERS DATABASE DELETED";
        }
        return "Incorrect delete code";
    }

/** * * * * * * * *
     Exception Handling
 */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exceptionHandler(Exception e) {
        System.out.println("\n\n### " + e);
        e.printStackTrace();
        return  e.getMessage();
    }

}
