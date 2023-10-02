package com.sportTogether.SportTogether.controller;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.sportTogether.SportTogether.dto.UsersDTO;
import com.sportTogether.SportTogether.payload.Response;
import com.sportTogether.SportTogether.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class userController {
    @Autowired
    UsersService usersService;

    @GetMapping(name = "/")
    public ResponseEntity<?> getAllUsers() {
        List<UsersDTO> data = usersService.getAllUsers();
        Response response = new Response(200, "Successfully", data);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email ,@RequestParam String password) {
        boolean data = usersService.findByEmailAndPassword(email,password);
        String message = (data) ?"Successfully" : "Unsuccessfully";
        Response response = new Response(200, message, data);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String email ,@RequestParam String password) {
        boolean data = usersService.register(email,password);
        String message = (data) ?"Successfully" : "Unsuccessfully";
        Response response = new Response(200, message, data);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
