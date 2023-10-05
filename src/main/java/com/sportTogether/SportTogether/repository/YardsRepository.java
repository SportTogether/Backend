package com.sportTogether.SportTogether.repository;

import com.sportTogether.SportTogether.entity.Users;
import com.sportTogether.SportTogether.entity.Yards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YardsRepository extends JpaRepository<Yards,Integer> {
    public Yards findById(int id ) ;
}
