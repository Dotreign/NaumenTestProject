package com.example.naumentest.controller;

import com.example.naumentest.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/name")
public class NameController {

    NameService nameService;

    @Autowired
    public NameController(NameService nameService) {
        this.nameService = nameService;
    }

    @GetMapping("/")
    public String getAge(@RequestParam("name") String name) {
        if (!name.isEmpty()) {
            String newName = new String(name.getBytes(StandardCharsets.UTF_8));
            Integer age = nameService.getAgeByName(newName);
            nameService.increaseRequestsNumber(newName);
            return String.valueOf(age);
        }
        return "Something went wrong";
    }

}
