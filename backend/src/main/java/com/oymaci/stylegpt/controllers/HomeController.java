package com.oymaci.stylegpt.controllers;

import com.oymaci.stylegpt.entity.Greeting;
import com.oymaci.stylegpt.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/")
    public String showHome(String name, Model model) {
        Greeting dockerGreeting = greetingService.findById(1).orElse(new Greeting("Not Found 😕"));
        model = model.addAttribute("name", dockerGreeting.getName());
        return "home";
    }

}
