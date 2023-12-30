package com.sportTogether.SportTogether.service;

import com.sportTogether.SportTogether.dto.Users_MatchesDTO;

public interface Users_MatchesService {
    public boolean isExistedUserInMatch (int user_id , int match_id );
    public boolean addNewUserMatch (int users_id , int matches_id);

    public boolean removeUserMatch (int user_matchId);
}
