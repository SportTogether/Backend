package com.sportTogether.SportTogether.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class userController implements RequestHandler<String ,String > {
//    @GetMapping
//    public ResponseEntity<?> getAllUsers ()
//    {
//        Response response = new Response( 200,"OKOK","hello world");
//
//        return new ResponseEntity<>(response, HttpStatus.OK) ;
//        }


    @Override
    public String handleRequest(String s, Context context) {
        return "hello world";
    }


}
