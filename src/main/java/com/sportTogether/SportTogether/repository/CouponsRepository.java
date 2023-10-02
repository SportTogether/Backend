package com.sportTogether.SportTogether.repository;

import com.sportTogether.SportTogether.entity.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponsRepository extends JpaRepository<Coupons,Integer> {

    public List<Coupons> findAll();

    public Coupons findById(int id );
}
