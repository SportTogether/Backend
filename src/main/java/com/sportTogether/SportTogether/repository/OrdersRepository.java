package com.sportTogether.SportTogether.repository;

import com.sportTogether.SportTogether.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    @Query(value = "select o from orders o where o.users.id = ?1")
    public List<Orders> findAllByUserId (int id );

    public Orders findById(int id );
    public List<Orders >findAll();

//    @Query(value = "select  o from orders o where o.users.id = ?1 order by o.id DESC LIMIT 1",nativeQuery = true)
    public Orders findTop1ByUsersIdOrderByIdDesc(int users_id);

}
