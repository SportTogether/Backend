package com.sportTogether.SportTogether.repository;

import com.sportTogether.SportTogether.entity.Matches;
import com.sportTogether.SportTogether.entity.Users;
import com.sportTogether.SportTogether.entity.Users_Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface Users_MatchesRepository extends JpaRepository<Users_Matches,Integer> {

    public Users_Matches findByUsers_idAndMatches_id(int  users_id , int  matches_id);

    @Transactional
    @Modifying
    @Query(value = "delete from users_matches um where um.users.id =?1 and um.matches.id =?2")
    public void removeUserMatch(int  users_id , int  matches_id);

    public Users_Matches findById(int id );



}
