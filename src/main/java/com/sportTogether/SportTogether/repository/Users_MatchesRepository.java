package com.sportTogether.SportTogether.repository;

import com.sportTogether.SportTogether.entity.Matches;
import com.sportTogether.SportTogether.entity.Users;
import com.sportTogether.SportTogether.entity.Users_Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users_MatchesRepository extends JpaRepository<Users_Matches,Integer> {

    public Users_Matches findByUsers_idAndMatches_id(int  users_id , int  matches_id);






}
