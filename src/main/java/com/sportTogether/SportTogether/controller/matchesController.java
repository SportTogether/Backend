package com.sportTogether.SportTogether.controller;

import com.sportTogether.SportTogether.dto.MatchesDTO;
import com.sportTogether.SportTogether.dto.OrdersDTO;
import com.sportTogether.SportTogether.payload.Response;
import com.sportTogether.SportTogether.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/matches")
public class matchesController {
    @Autowired
    MatchesService matchesService;
    @GetMapping("")
    public ResponseEntity<?> findAllMatches ()
    {

        List<MatchesDTO> data = matchesService.findAllMatches();
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((!data.isEmpty()) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewMatch (@RequestBody MatchesDTO matchesDTO)
    {

        boolean data = matchesService.addNewMatch(matchesDTO);

        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((data) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/cancel")
    public ResponseEntity<?> cancelMatch (@RequestBody MatchesDTO matchesDTO)
    {

        boolean data = matchesService.cancelMatch(matchesDTO);

        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((data) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
