package com.sportTogether.SportTogether.service.imp;

import com.sportTogether.SportTogether.dto.MatchesDTO;
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

import java.util.ArrayList;
import java.util.List;

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
        try {
            System.out.println("Enter here");
            Users users = usersRepository.findById(user_id);
            Matches matches = matchesRepository.findById(match_id);
            int users_id = users.getId();
            int matches_id = matches.getId();
            Users_Matches usersMatches = usersMatchesRepository.findByUsers_idAndMatches_id(users_id, matches_id);
            return usersMatches != null;
        } catch (Exception e) {
            System.out.println("Error in Users_MatchesServiceImp : " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean addNewUserMatch(int users_id, int matches_id) {
        boolean isExisted = isExistedUserInMatch(users_id, matches_id);
        if (isExisted) {
            return false;
        } else {

            try {
                Users users = usersRepository.findById(users_id);
                Matches matches = matchesRepository.findById(matches_id);
                Users_Matches usersMatches = new Users_Matches();
                usersMatches.setUsers(users);
                usersMatches.setMatches(matches);
                if (users != null && matches != null) {
                    usersMatchesRepository.save(usersMatches);
                    return true;
                } else {
                    return false;
                }


            } catch (Exception e) {
                System.out.println("Error in Users_MatchesServiceImp : " + e.getMessage());
                return false;
            }

        }
    }

    @Override
    public boolean removeUserMatch(int users_id , int matches_id) {
        boolean isExisted = isExistedUserInMatch(users_id, matches_id);
        if (isExisted ==false) {
            return false;
        } else {

            try {
                System.out.println("Enter here");
                Users users = usersRepository.findById(users_id);
                Matches matches = matchesRepository.findById(matches_id);
                usersMatchesRepository.removeUserMatch(users_id,matches_id);
                return true ;


            } catch (Exception e) {
                System.out.println("Error in Users_MatchesServiceImp : " + e.getMessage());
                return false;
            }

        }
    }

    public List<MatchesDTO> findByUsers_Id(int user_id )
    {
        List <Matches> matches = usersMatchesRepository.findByUsers_Id(user_id);
        if (matches !=null)
        {
            List<MatchesDTO> matchesDTOS = new ArrayList<>();
            for (Matches match : matches
                 ) {

                MatchesDTO matchesDTO= new MatchesDTO();
                matchesDTO.setName(match.getName());
                matchesDTO.setTime(match.getTime());
                matchesDTO.setIcon(match.getIcon());
                matchesDTO.setId(match.getId());
                matchesDTO.setAddress(match.getAddress());
                matchesDTO.setCurrent_quantities(match.getCurrent_quantities());
                matchesDTO.setMax_quantities(match.getMax_quantities());
                matchesDTOS.add(matchesDTO);
            }
            return matchesDTOS;
        }else
        {
            return new ArrayList<>();
        }
    }
}
