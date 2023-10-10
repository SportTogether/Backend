package com.sportTogether.SportTogether.controller;

import com.sportTogether.SportTogether.dto.CouponsDTO;
import com.sportTogether.SportTogether.dto.OrdersDTO;
import com.sportTogether.SportTogether.dto.OrdersRigsterDTO;
import com.sportTogether.SportTogether.dto.UsersDTO;
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
@CrossOrigin
public class ordersController {
    @Autowired
    OrdersService ordersService;
    @PostMapping("/find/user_id")
    public ResponseEntity<?> findAllByUserId (@RequestBody UsersDTO usersDTO )
    {
        int id = usersDTO.getId();
        List<OrdersDTO> data = ordersService.getAllOrdersByUserId(id);
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((!data.isEmpty()) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewOrder (@RequestBody OrdersRigsterDTO ordersRigsterDTO)
    {

        boolean data = ordersService.addNewOrder(ordersRigsterDTO);
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(data);
        response.setMessage((data) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

