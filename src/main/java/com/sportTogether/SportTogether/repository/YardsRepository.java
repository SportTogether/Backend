package com.sportTogether.SportTogether.repository;

import com.sportTogether.SportTogether.entity.Users;
import com.sportTogether.SportTogether.entity.Yards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YardsRepository extends JpaRepository<Yards,Integer> {
    public Yards findById(int id ) ;

    @Query(value = "select y from yards y where y.type like concat('%',?1,'%')   or y.stars.quantities = ?1")
    public List<Yards> filterByType(String type) ;

    @Query(value = "select y from yards y where y.type like concat('%',?1,'%')   and y.stars.quantities = ?2")
    public List<Yards> filterByAll(String type, int  stars ) ;
}
//(y.type like concat('%',?1,'%') and  y.stars.quantities = ?2) or