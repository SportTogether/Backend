package com.sportTogether.SportTogether.repository;

import com.sportTogether.SportTogether.entity.Users_Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Users_CouponsRepository extends JpaRepository<Users_Coupons,Integer> {
    public Users_Coupons findByUsers_idAndCoupons_id(int usersId , int couponsId ) ;




}
