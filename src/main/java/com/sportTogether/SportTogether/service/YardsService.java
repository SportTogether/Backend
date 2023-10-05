package com.sportTogether.SportTogether.service;

import com.sportTogether.SportTogether.dto.YardsDTO;
import com.sportTogether.SportTogether.entity.Yards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface YardsService  {
    public YardsDTO getYardById (int id );
    public List<YardsDTO> getAllYards();
}
