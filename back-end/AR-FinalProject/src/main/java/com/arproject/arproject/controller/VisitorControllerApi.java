package com.arproject.arproject.controller;

import com.arproject.arproject.model.Visitor;
import com.arproject.arproject.service.VisitorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class VisitorControllerApi {

    @Autowired
    VisitorService visitorService;

  // --- JSON to Java Obj ---
    private ObjectMapper objMap = new ObjectMapper();

  // *** ADD VISITOR ***
    @PostMapping("/api/add_visitor")
    public Visitor addNewVisitor(@RequestBody String json) throws IOException {
        Visitor addVisitor = objMap.readValue(json, Visitor.class);
        return visitorService.addVisitor(addVisitor); }

  // *** GET VISITOR ***
    // --- BY EMAIL ---
    @GetMapping("/api/get_one_visitor/{visitorEmail}")
    public Visitor getOneVisitor(@PathVariable(name = "visitorEmail") String email) {
        return visitorService.findByEmail(email); }

    // --- BY USER ID ---
    @GetMapping("/api/get_one_visitor/{visitorId}")
    public Visitor getOneVisitor(@PathVariable(name = "visitorId") int id) {
        return visitorService.getVisitor(id); }

  // *** GET ALL VISITORS ***
    @GetMapping("/api/get_all_visitors")
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }

  // *** DELETE ALL VISITORS - dev only ***
    @DeleteMapping("/api/delete_all_visitors/{deleteCode}")
    public String deleteAllUsers(@PathVariable("deleteCode") Integer deleteCode) {
        if (deleteCode.equals(11022017)) {
            visitorService.deleteAll();
        }
        return "DATABASE DELETED";
    }

  // *** EXCEPTION HANDLER ***
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exceptionHandler(Exception e) {
        System.out.println("\n\n### " + e);
        e.printStackTrace();
        return  e.getMessage();
    }
}
