package com.example.Firstproject.API;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //JSON��ȯ ��Ʈ�ѷ�
public class FirstAPIController {

    @GetMapping("/api/hello")
    public String hello(){
        return "hello world";
    }
}
