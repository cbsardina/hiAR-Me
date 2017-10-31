package com.arproject.arproject.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(Throwable.class)
    public ModelAndView exception(Throwable throwable) {
        String errorMsg = throwable != null ? throwable.getMessage() :"Unknown error";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("errorMessage", errorMsg);
        modelAndView.setViewName("error");
        return modelAndView;
    }

    /** from thymeleaf examples */
}
