package com.sportTogether.SportTogether.service.imp;

import com.sportTogether.SportTogether.dto.OrdersDTO;
import com.sportTogether.SportTogether.dto.UsersDTO;
import com.sportTogether.SportTogether.entity.Orders;
import com.sportTogether.SportTogether.entity.Status;
import com.sportTogether.SportTogether.entity.Users;
import com.sportTogether.SportTogether.entity.Yards;
import com.sportTogether.SportTogether.repository.OrdersRepository;
import com.sportTogether.SportTogether.repository.StatusRepository;
import com.sportTogether.SportTogether.repository.UsersRepository;
import com.sportTogether.SportTogether.repository.YardsRepository;
import com.sportTogether.SportTogether.service.OrdersService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImp implements OrdersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    YardsRepository yardsRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Override
    public List<OrdersDTO> getAllOrdersByUserId(int id) {
        List<OrdersDTO> ordersDTOS = new ArrayList<>();

        List<Orders> orders = ordersRepository.findAllByUserId(id); //error here

        System.out.println("size "+orders.size());
        if (!orders.isEmpty()) {
            for (Orders order : orders) {

                String name, email, number, statusName, yardName, startTime;
                //set User
                try {

                    Users user = order.getUsers();
                    name = user.getName();
                    email = user.getEmail();
                    number = user.getNumber();
                } catch (Exception e) {
                    System.out.println("Error in getAllOrdersByUserId method (OrderServiceImp) " + e.getMessage());
                    return ordersDTOS;
                }


                //set status
                try {
                    Status status = order.getStatus();
                    statusName = status.getName();
                } catch (Exception e) {
                    System.out.println("Error in getAllOrdersByUserId method (OrderServiceImp) " + e.getMessage());
                    return ordersDTOS;
                }


                //set yard
                try {
                    Yards yard = order.getYards();
                    yardName = yard.getName();
                    startTime = order.getStartTime();
                } catch (Exception e) {
                    System.out.println("Error in getAllOrdersByUserId method (OrderServiceImp) " + e.getMessage());
                    return ordersDTOS;
                }
                OrdersDTO ordersDTO = new OrdersDTO(name, email, number, yardName, startTime, statusName);
                ordersDTOS.add(ordersDTO);

            }
        }


        return ordersDTOS;
    }

    @Override
    public boolean addNewOrder(int userId, int yardsId, int statusId, String startDate, String endDate) {
            statusId = 1;
            try {
                Users user = usersRepository.findById(userId);
                Yards yard = yardsRepository.findById(yardsId);
                Status status = statusRepository.findById(statusId);
                Orders order = new Orders(user,yard,status,startDate,endDate);
                ordersRepository.save(order);
                return true ;
            }catch (Exception e )
            {
                System.out.println("Error in addNewOrder method (OrderServiceImp) " + e.getMessage());
                return false ;

            }

    }
}
