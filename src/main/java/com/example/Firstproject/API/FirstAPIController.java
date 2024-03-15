package com.example.Firstproject.API;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //JSON반환 컨트롤러
public class FirstAPIController {

    @GetMapping("/api/hello")
    public String hello(){
        return "hello world";
    }
}
