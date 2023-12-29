package com.sportTogether.SportTogether.service;

import com.sportTogether.SportTogether.dto.MatchesDTO;

import java.util.List;

public interface MatchesService {
    public List<MatchesDTO> findAllMatches ();
    public boolean addNewMatch (MatchesDTO matchesDTO );

    public boolean cancelMatch (MatchesDTO matchesDTO );
}
