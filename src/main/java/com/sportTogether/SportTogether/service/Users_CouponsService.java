package com.sportTogether.SportTogether.service;

public interface Users_CouponsService {
    public boolean isExistedByUsers_idAndCoupons_id (int usersId , int couponsId);

    public boolean addNewUsers_Coupons(int usersId ,int couponsId );
}
