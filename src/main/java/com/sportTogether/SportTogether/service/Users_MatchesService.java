package com.sportTogether.SportTogether.service;

import com.sportTogether.SportTogether.dto.MatchesDTO;
import com.sportTogether.SportTogether.dto.Users_MatchesDTO;
import com.sportTogether.SportTogether.entity.Users_Matches;

import java.util.List;

public interface Users_MatchesService {
    public boolean isExistedUserInMatch (int user_id , int match_id );
    public boolean addNewUserMatch (int users_id , int matches_id);

    public boolean removeUserMatch (int users_id , int matches_id);

    public List<MatchesDTO> findByUsers_Id(int user_id );
}
