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
            String number = users.get(i).getNumber();
            int  id = users.get(i).getId();

            UsersDTO usersDTO = new UsersDTO(id ,name , email,password,number);
            usersDTOS.add(usersDTO) ;
        }
        return usersDTOS;
    }

    @Override
    public UsersDTO findByEmailAndPassword(String email, String password) {
        UsersDTO usersDTO = new UsersDTO();
        try
        {
            Users user = usersRepository.findByEmailAndPassword(email,password);

            if (user!=null)
            {
                usersDTO.setId(user.getId());
                usersDTO.setEmail(user.getEmail());
                usersDTO.setPassword(user.getPassword());
                usersDTO.setNumber(user.getNumber());
                usersDTO.setName(user.getName());
                usersDTO.setRole_name(user.getRoles().getName());
            }

            return usersDTO ;
        }catch (Exception e )
        {
            System.out.println("Error in findByEmailAndPassword method (UserService) : "+e.getMessage());
            return usersDTO ;
        }

    }

    @Override
    public boolean register(String email, String password,String name,String number ) {
        Users user = usersRepository.findByEmail(email);
        if (user ==null)
        {
            Users newUser = new Users();
            newUser.setEmail(email);
            newUser.setPassword(password);
            newUser.setName(name);
            newUser.setNumber(number);
            usersRepository.save(newUser);
            return true ;
        }else
        {
            System.out.println("Email has been registered !!!");
            return false ;
        }
    }
}
