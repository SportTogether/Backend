package com.sportTogether.SportTogether.controller;

import com.sportTogether.SportTogether.dto.YardsDTO;
import com.sportTogether.SportTogether.payload.Response;
import com.sportTogether.SportTogether.service.Users_CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users_coupons")
@CrossOrigin
public class users_couponsController {

    @Autowired
    Users_CouponsService usersCouponsService;

    @PostMapping("")
    public ResponseEntity<?>addNewCouponForUser(@RequestParam int user_id , @RequestParam int coupon_id )
    {
        boolean add = usersCouponsService.addNewUsers_Coupons(user_id,coupon_id);
        System.out.println("Entered here");
        Response response = new Response();
        response.setStatusCode(200);
        response.setData(add);
        response.setMessage((add) ?"Successfully":"Unsuccessfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
