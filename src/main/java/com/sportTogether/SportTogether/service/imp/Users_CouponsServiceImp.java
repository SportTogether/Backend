package com.sportTogether.SportTogether.service.imp;

import com.sportTogether.SportTogether.entity.Coupons;
import com.sportTogether.SportTogether.entity.Users;
import com.sportTogether.SportTogether.entity.Users_Coupons;
import com.sportTogether.SportTogether.repository.CouponsRepository;
import com.sportTogether.SportTogether.repository.UsersRepository;
import com.sportTogether.SportTogether.repository.Users_CouponsRepository;
import com.sportTogether.SportTogether.service.Users_CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Users_CouponsServiceImp implements Users_CouponsService {

    @Autowired
    Users_CouponsRepository usersCouponsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    CouponsRepository couponsRepository;
    @Override
    public boolean isExistedByUsers_idAndCoupons_id(int usersId, int couponsId) {
        Users_Coupons usersCoupons = usersCouponsRepository.findByUsers_idAndCoupons_id(usersId, couponsId);
        return usersCoupons !=null;
    }

    @Override
    public boolean addNewUsers_Coupons(int usersId, int couponsId) {
        boolean isExisted = isExistedByUsers_idAndCoupons_id(usersId,couponsId);
        if (!isExisted)
        {
            Users user =  usersRepository.findById(usersId);
            Coupons coupon = couponsRepository.findById(couponsId);
            Users_Coupons usersCoupons= new Users_Coupons(user,coupon);

            usersCouponsRepository.save(usersCoupons);
            return true ;
        }
        return false ;

    }
}
