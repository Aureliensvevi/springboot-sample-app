package com.example.demo.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Utilities;

@RestController
@RequestMapping("/api")
public class Controller {



    @GetMapping("/xss")
    public String xss(@RequestParam String id) {
        return id;
    }

    @GetMapping("/os-injection")
    public String os(@RequestParam String id) {
        return Utilities.execCommandsAndSendResults(id);

    }



}
