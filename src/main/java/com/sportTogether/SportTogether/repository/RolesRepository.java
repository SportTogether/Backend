package com.sportTogether.SportTogether.repository;

import com.sportTogether.SportTogether.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {

    public Roles findById(int id );
}
