package com.sportTogether.SportTogether.service;

import com.sportTogether.SportTogether.dto.OrdersDTO;
import com.sportTogether.SportTogether.dto.OrdersRigsterDTO;
import com.sportTogether.SportTogether.entity.Orders;

import java.util.List;

public interface OrdersService {
    public List<OrdersDTO> getAllOrdersByUserId (int id );
    public boolean addNewOrder(OrdersRigsterDTO ordersRigsterDTO);
    public boolean updateOrdersByStatusId (int status_id ,int orders_id  );

    public int findLastIdFromUsers_id(int users_id);
}
