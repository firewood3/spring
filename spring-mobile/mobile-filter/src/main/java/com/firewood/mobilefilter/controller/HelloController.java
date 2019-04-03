package com.firewood.mobilefilter.controller;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
    @GetMapping("/home")
    public String home(HttpServletRequest request) {
        Device device = (Device) request.getAttribute("currentDevice");
        System.out.println(device.isMobile());
        System.out.println(device.isNormal());
        System.out.println(device.isTablet());
        System.out.println(device.getDevicePlatform().toString());
        return "home";
    }
}
