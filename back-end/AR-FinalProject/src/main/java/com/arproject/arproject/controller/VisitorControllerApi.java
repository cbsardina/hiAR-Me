package com.arproject.arproject.controller;

import com.arproject.arproject.model.Visitor;
import com.arproject.arproject.service.VisitorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@RestController
public class VisitorControllerApi {

    @Autowired
    VisitorService visitorService;

/** * * * * * * * *
     JSON to Java Obj
 */
    private ObjectMapper objMap = new ObjectMapper();

/** * * * * * * * *
     Add Visitor
 */
    @PostMapping("/api/visitor/add_visitor_send_email")
    public Visitor addNewVisitor(@RequestBody String json, final Locale locale) throws MessagingException, IOException {
        Visitor visitor = objMap.readValue(json, Visitor.class);
        return visitorService.addVisitor(visitor);
    }


/** * * * * * * * *
     Get Visitor
 */
    @GetMapping("/api/visitor/{id}")
    public Visitor getOneVisitor(@PathVariable(name = "id") int id) {
        return visitorService.getVisitor(id); }

/** * * * * * * * *
     Get All Visitors
 */
    @GetMapping("/api/visitor/get_all")
    public List<Visitor> getAllVisitors() {
        return visitorService.getAllVisitors();
    }

/** * * * * * * * *
                *** DELETE ALL ***
 */
    @DeleteMapping("/api/delete_all_visitors/{deleteCode}")
    public String deleteAllUsers(@PathVariable("deleteCode") Integer deleteCode) {
        if (deleteCode.equals(11022017)) {
            visitorService.deleteAll();
        }
        return "DATABASE DELETED";
    }

/** * * * * * * * *
     Email Specific
 */
//    @GetMapping("/editable.html")
//    public String editableEmail(final Model model) throws IOException {
//        model.addAttribute("baseTemplate", this.emailService.getEditableMailTemplate());
//        return "editable";
//    }

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
