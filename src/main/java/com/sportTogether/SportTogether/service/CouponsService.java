package com.sportTogether.SportTogether.service;

import com.sportTogether.SportTogether.dto.CouponsDTO;

import java.util.List;

public interface CouponsService {
    public CouponsDTO findById (int id ) ;

    public List<CouponsDTO> findAll ();
}
