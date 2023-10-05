package com.sportTogether.SportTogether.repository;

import com.sportTogether.SportTogether.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
    public Status findById(int id );
}
