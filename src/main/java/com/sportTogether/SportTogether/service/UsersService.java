package com.sportTogether.SportTogether.service;

import com.sportTogether.SportTogether.dto.UsersDTO;

import java.util.List;

public interface UsersService  {
    public List<UsersDTO> getAllUsers();
    public UsersDTO findByEmailAndPassword (String email ,String password );

    public boolean register(String email,String password,String name,String number ) ;
}
