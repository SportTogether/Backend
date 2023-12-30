package com.sportTogether.SportTogether.service.imp;

import com.sportTogether.SportTogether.dto.Users_MatchesDTO;
import com.sportTogether.SportTogether.entity.Matches;
import com.sportTogether.SportTogether.entity.Users;
import com.sportTogether.SportTogether.entity.Users_Matches;
import com.sportTogether.SportTogether.repository.MatchesRepository;
import com.sportTogether.SportTogether.repository.UsersRepository;
import com.sportTogether.SportTogether.repository.Users_MatchesRepository;
import com.sportTogether.SportTogether.service.Users_MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Users_MatchesServiceImp implements Users_MatchesService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    MatchesRepository matchesRepository;

    @Autowired
    Users_MatchesRepository usersMatchesRepository;
    @Override
    public boolean isExistedUserInMatch(int user_id, int match_id) {
        try
        {
            System.out.println("Enter here");
            Users users = usersRepository.findById(user_id);
            Matches  matches= matchesRepository.findById(match_id);
            int users_id = users.getId();
            int matches_id = matches.getId();
            Users_Matches usersMatches = usersMatchesRepository.findByUsers_idAndMatches_id(users_id,matches_id);
            return usersMatches != null;
        }catch (Exception e )
        {
            System.out.println("Error in Users_MatchesServiceImp : "+e.getMessage());
            return false ;
        }
    }
}
