package com.internship.accesa.webApp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class MainController {

    private static final String HOME_PAGE = "home";

    @GetMapping()
    public String getHomePage() {
        return HOME_PAGE;
    }
}
