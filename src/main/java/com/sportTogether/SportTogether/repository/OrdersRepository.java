package com.sportTogether.SportTogether.repository;

import com.sportTogether.SportTogether.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    @Query(value = "select o from orders o where o.users.id = ?1")
    public List<Orders> findAllByUserId (int id );

    public List<Orders >findAll();
}
