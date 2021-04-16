package com.csrohit.resourcehandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {


    @RequestMapping("**")
    ResponseEntity<String> fallback(){
        return new ResponseEntity<String>( HttpStatus.NOT_FOUND);
    }
    @GetMapping("")
    public String abc(){
        return "hello";
    }
}
