package com.sportTogether.SportTogether.repository;

import com.sportTogether.SportTogether.entity.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MatchesRepository extends JpaRepository<Matches,Integer> {


    @Modifying
    @Transactional
    @Query(value = "update matches m set m.current_quantities =?2 where m.id=?1")

    public void updateMatchById(int id,int current );

    public Matches findById(int id ) ;
}
