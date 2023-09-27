package com.sportTogether.SportTogether.controller;

import com.sportTogether.SportTogether.payload.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class userController {
    @GetMapping
    public ResponseEntity<?> getAllUsers ()
    {
        Response response = new Response( 200,"OKOK","hello world");

        return new ResponseEntity<>(response, HttpStatus.OK) ;
    }
}
