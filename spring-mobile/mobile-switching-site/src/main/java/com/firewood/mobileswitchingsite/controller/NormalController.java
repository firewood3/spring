package com.firewood.mobileswitchingsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class NormalController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
