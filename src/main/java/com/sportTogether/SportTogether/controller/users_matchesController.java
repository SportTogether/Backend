package com.sportTogether.SportTogether.controller;

import com.sportTogether.SportTogether.dto.YardsDTO;
import com.sportTogether.SportTogether.payload.Response;
import com.sportTogether.SportTogether.service.Users_MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users_matches")
@CrossOrigin
public class users_matchesController {

    @Autowired
    Users_MatchesService usersMatchesService;

    @PostMapping("")
    public ResponseEntity<?> isExistedUserInMatch(@RequestParam int users_id ,@RequestParam int matches_id )
    {
        System.out.println("enter here");
        boolean data = usersMatchesService.isExistedUserInMatch(users_id,matches_id);
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((data) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewUserMatch(@RequestParam int users_id ,@RequestParam int matches_id )
    {

        boolean data = usersMatchesService.addNewUserMatch(users_id,matches_id);
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((data) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/remove")
    public ResponseEntity<?> removeUserMatch(@RequestParam int users_id ,@RequestParam int matches_id )
    {

        boolean data = usersMatchesService.removeUserMatch(users_id,matches_id);
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((data) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
