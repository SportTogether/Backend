package com.sportTogether.SportTogether.repository;

import com.sportTogether.SportTogether.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

    public List<Users> findAll ();
}
