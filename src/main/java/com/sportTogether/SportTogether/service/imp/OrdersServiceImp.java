package com.sportTogether.SportTogether.service.imp;

import com.sportTogether.SportTogether.dto.OrdersDTO;
import com.sportTogether.SportTogether.dto.OrdersRigsterDTO;
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

        System.out.println("size " + orders.size());
        if (!orders.isEmpty()) {
            for (Orders order : orders) {

                String name, email, number, yardName, startTime;
                int statusName =0;
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
                    statusName = status.getId();
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
                OrdersDTO ordersDTO = new OrdersDTO(0,name, email, number, yardName, startTime, statusName);
                ordersDTOS.add(ordersDTO);

            }
        }


        return ordersDTOS;
    }

    @Override
    public boolean addNewOrder(OrdersRigsterDTO ordersRigsterDTO) {
        int users_id = ordersRigsterDTO.getUsers_id();
        int yards_id = ordersRigsterDTO.getYards_id();
        int status_id = 1;
        String start_date = ordersRigsterDTO.getStart_date();
        String end_date = ordersRigsterDTO.getEnd_date();


        try {
            Users user = usersRepository.findById(users_id);
            Yards yard = yardsRepository.findById(yards_id);
            Status status = statusRepository.findById(status_id);
            System.out.println("start date "+start_date);
            System.out.println("end date "+end_date);
            if (start_date ==null|| end_date ==null)
            {
                System.out.println("zo day ");
                return false;
            }

            Orders order = new Orders(user, yard, status, start_date, end_date);
            ordersRepository.save(order);
            return true;
        } catch (Exception e) {
            System.out.println("Error in addNewOrder method (OrderServiceImp) " + e.getMessage());
            return false;

        }

    }

    @Override
    public boolean updateOrdersByStatusId(int status_id,int users_id) {
        int orders_id = findLastIdFromUsers_id(users_id);
        Orders orders = ordersRepository.findById(orders_id);
        if (status_id==0)
        {
            return false;
        }else
        {
            Status status = statusRepository.findById(status_id);
            orders.setStatus(status);
            ordersRepository.save(orders);
            return true ;
        }


    }

    @Override
    public int findLastIdFromUsers_id(int users_id) {
        Orders orders = ordersRepository.findTop1ByUsersIdOrderByIdDesc(users_id);

        return orders.getId();
    }
}
