package com.sportTogether.SportTogether.service.imp;

import com.sportTogether.SportTogether.dto.CouponsDTO;
import com.sportTogether.SportTogether.entity.Coupons;
import com.sportTogether.SportTogether.repository.CouponsRepository;
import com.sportTogether.SportTogether.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponsServiceImp implements CouponsService {
    @Autowired
    CouponsRepository couponsRepository;
    @Override
    public CouponsDTO findById(int  id) {
        Coupons coupon = couponsRepository.findById(id);
        if (coupon != null)
        {
            CouponsDTO couponsDTO = new CouponsDTO();
            couponsDTO.setName(coupon.getName());
            couponsDTO.setDescription(coupon.getDescription());
            couponsDTO.setDiscount(coupon.getDiscount());
            couponsDTO.setId(coupon.getId());


            return couponsDTO;
        }else
        {
           return null;
        }
    }

    @Override
    public List<CouponsDTO> findAll() {
        List<CouponsDTO> couponsDTOS= new ArrayList<>();
        List<Coupons> coupons = couponsRepository.findAll();
        for (Coupons coupon: coupons
             ) {
            CouponsDTO couponsDTO = new CouponsDTO();
            couponsDTO.setId(coupon.getId());
            couponsDTO.setDiscount(coupon.getDiscount());

            couponsDTO.setName(coupon.getName());
            couponsDTO.setDescription(coupon.getDescription());
            couponsDTOS.add(couponsDTO);
        }
        return couponsDTOS;
    }
}
