package com.example.oauth2service.controller;

import com.example.oauth2service.handler.CustomSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController
{
    CustomSuccessHandler customSuccessHandler;

    @Autowired
    public MainController(CustomSuccessHandler customSuccessHandler)
    {
        this.customSuccessHandler = customSuccessHandler;
    }

    @GetMapping(value = "/google")
    public String googleAuth()
    {
        return "http://localhost:8081/login/oauth2/code/google";
    }
}
