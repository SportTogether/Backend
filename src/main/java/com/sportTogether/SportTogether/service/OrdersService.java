package com.sportTogether.SportTogether.service;

import com.sportTogether.SportTogether.dto.OrdersDTO;

import java.util.List;

public interface OrdersService {
    public List<OrdersDTO> getAllOrdersByUserId (int id );
    public boolean addNewOrder(int userId , int yardsId , int statusId , String startDate , String endDate );
}
