package com.oauth.oauthserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {
    @GetMapping(path = "/")
    public ResponseEntity<String> HomePage(){
        String apiResponse = "Home Page";
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/gettest")
    public ResponseEntity<String> GetTest(){
        String apiResponse = "GET success";
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
