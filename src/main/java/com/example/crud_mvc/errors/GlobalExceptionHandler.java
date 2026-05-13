package com.example.crud_mvc.errors;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public String manejar(Exception ex, Model model) {
        model.addAttribute("mensaje", ex.getMessage());
        return "error";
    }
}
