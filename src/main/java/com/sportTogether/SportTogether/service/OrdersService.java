package com.sportTogether.SportTogether.service;

import com.sportTogether.SportTogether.dto.OrdersDTO;
import com.sportTogether.SportTogether.dto.OrdersRigsterDTO;

import java.util.List;

public interface OrdersService {
    public List<OrdersDTO> getAllOrdersByUserId (int id );
    public boolean addNewOrder(OrdersRigsterDTO ordersRigsterDTO);
}
