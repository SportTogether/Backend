package com.sportTogether.SportTogether.service.imp;

import com.sportTogether.SportTogether.dto.CouponsDTO;
import com.sportTogether.SportTogether.entity.Coupons;
import com.sportTogether.SportTogether.repository.CouponsRepository;
import com.sportTogether.SportTogether.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            couponsDTO.setIcon(coupon.getIcon());
            couponsDTO.setId(coupon.getId());

            return couponsDTO;
        }else
        {
           return null;
        }
    }
}
