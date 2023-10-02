package com.sportTogether.SportTogether.service.imp;

import com.sportTogether.SportTogether.dto.UsersDTO;
import com.sportTogether.SportTogether.entity.Users;
import com.sportTogether.SportTogether.repository.UsersRepository;
import com.sportTogether.SportTogether.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.font.FontRenderContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImp implements UsersService {

    @Autowired
    UsersRepository usersRepository;
    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> users = usersRepository.findAll();
        List<UsersDTO> usersDTOS = new ArrayList<>();
        for (int i = 0; i <users.size(); i++) {
            String name = users.get(i).getName();
            String email = users.get(i).getEmail();
            String password = users.get(i).getPassword();
            int  id = users.get(i).getId();

            UsersDTO usersDTO = new UsersDTO(id ,name , email,password);
            usersDTOS.add(usersDTO) ;
        }
        return usersDTOS;
    }
}
