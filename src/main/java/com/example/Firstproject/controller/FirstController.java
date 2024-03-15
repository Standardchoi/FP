package com.example.Firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    @GetMapping("/hi")
    public String niceTomeetYou(Model model){
        model.addAttribute("userName","정식");
        return "greeting";
    }
    @GetMapping("/bye")
    public String byebye(Model model){
        model.addAttribute("userName","정식");
        return "goodbye";
    }


}
