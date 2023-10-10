package com.sportTogether.SportTogether.controller;

import com.sportTogether.SportTogether.dto.CouponsDTO;
import com.sportTogether.SportTogether.dto.YardsDTO;
import com.sportTogether.SportTogether.payload.Response;
import com.sportTogether.SportTogether.service.CouponsService;
import com.sportTogether.SportTogether.service.YardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/yards")
@CrossOrigin
public class yardsController {
    @Autowired
    YardsService yardsService;

    @GetMapping("/find/id")
    public ResponseEntity<?> findById (@RequestParam int id )
    {
        YardsDTO data = yardsService.getYardById(id);
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((data != null) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/filter/type")
    public ResponseEntity<?> filterByType (@RequestParam String name )
    {
        List<YardsDTO> data = yardsService.filterByType(name);
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((!data.isEmpty()) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/filter/stars")
    public ResponseEntity<?> filterByStars (@RequestParam int   name )
    {
        List<YardsDTO> data = yardsService.filterByStars(name);
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((!data.isEmpty()) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> findAll ()
    {
        List<YardsDTO> data = yardsService.getAllYards();
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((!data.isEmpty()) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

