package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckingApplicationController {

    @GetMapping("checking/")
    public String checking(){
        return "Application Working Perfectly";
    }
}
