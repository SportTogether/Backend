package com.sportTogether.SportTogether.controller;

import com.sportTogether.SportTogether.dto.CouponsDTO;
import com.sportTogether.SportTogether.payload.Response;
import com.sportTogether.SportTogether.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/coupons")
@CrossOrigin
public class couponController {
    @Autowired
    CouponsService couponsService;

    @GetMapping("/find/id")
    public ResponseEntity<?> findById (@RequestParam int id )
    {
        CouponsDTO data = couponsService.findById(id);
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((data != null) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> findAll ( )
    {
        List<CouponsDTO> data = couponsService.findAll();
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((!data.isEmpty()) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
