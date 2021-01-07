package com.example.oauth2service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/authService")
public class MainController
{
    @GetMapping("/google")
    public String googleAuth()
    {
        return "/oauth2/authorization/google";
    }
}
