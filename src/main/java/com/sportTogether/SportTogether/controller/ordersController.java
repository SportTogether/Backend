package com.sportTogether.SportTogether.controller;

import com.sportTogether.SportTogether.dto.CouponsDTO;
import com.sportTogether.SportTogether.dto.OrdersDTO;
import com.sportTogether.SportTogether.payload.Response;
import com.sportTogether.SportTogether.service.CouponsService;
import com.sportTogether.SportTogether.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/orders")
public class ordersController {
    @Autowired
    OrdersService ordersService;
    @GetMapping("/findAllByUserId")
    public ResponseEntity<?> findAllByUserId (@RequestParam int id )
    {

        List<OrdersDTO> data = ordersService.getAllOrdersByUserId(id);
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((!data.isEmpty()) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewOrder (@RequestParam int users_id ,@RequestParam int yards_id ,
                                          @RequestParam int status_id ,
                                          @RequestParam String start_date ,
                                          @RequestParam String end_date )
    {

        boolean data = ordersService.addNewOrder(users_id,yards_id,status_id,start_date,end_date);
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((data) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

