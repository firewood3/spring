package com.firewood.mobileswitchingsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/m")
public class MobileController {
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
