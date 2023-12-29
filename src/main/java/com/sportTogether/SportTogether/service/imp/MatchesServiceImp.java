package com.sportTogether.SportTogether.service.imp;

import com.sportTogether.SportTogether.dto.MatchesDTO;
import com.sportTogether.SportTogether.entity.Matches;
import com.sportTogether.SportTogether.repository.MatchesRepository;
import com.sportTogether.SportTogether.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchesServiceImp implements MatchesService {

    @Autowired
    MatchesRepository matchesRepository;

    @Override
    public List<MatchesDTO> findAllMatches() {
        List<Matches> matches = matchesRepository.findAll();
        if (!matches.isEmpty()) {
            List<MatchesDTO> matchesDTOS = new ArrayList<>();
            for (Matches match : matches
            ) {
                MatchesDTO matchesDTO = new MatchesDTO();
                matchesDTO.setId(match.getId());
                matchesDTO.setAddress(match.getAddress());
                matchesDTO.setIcon(match.getIcon());
                matchesDTO.setName(match.getName());
                matchesDTO.setTime(match.getTime());
                matchesDTO.setCurrent_quantities(match.getCurrent_quantities());
                matchesDTO.setMax_quantities(match.getMax_quantities());
                matchesDTOS.add(matchesDTO);

            }
            return matchesDTOS;
        } else {
            return new ArrayList<>();
        }
    }

    private boolean checkValid (Matches matchesDTO,int cases )
    {
        int current = matchesDTO.getCurrent_quantities();
        int max = matchesDTO.getMax_quantities();
        //case : 1 =>add , 0 => cancel
        if (cases ==1 )
        {
            return current < max && current >= 0;
        }else if (cases== 0 )
        {
            return current <= max && current > 0;
        }
        return false ;
    }
    @Override
    public boolean addNewMatch(MatchesDTO matchesDTO) {
        int id = matchesDTO.getId();

        try
        {

                Matches match =  matchesRepository.findById(id);
                if (checkValid(match,1)) {
                    matchesRepository.updateMatchById(id, match.getCurrent_quantities() + 1);
                    return true;
                }

        }
        catch (Exception e )
        {
            System.out.println("Error in MatchesServiceImp :"+e.getMessage());
            return false ;
        }
        return false ;
    }

    @Override
    public boolean cancelMatch(MatchesDTO matchesDTO) {
        int id = matchesDTO.getId();

        try
        {
            Matches match =  matchesRepository.findById(id);
            if (checkValid(match,0)) {
                matchesRepository.updateMatchById(id, match.getCurrent_quantities() - 1);
                return true;
            }
        }
        catch (Exception e )
        {
            System.out.println("Error in MatchesServiceImp :"+e.getMessage());
            return false ;
        }
        return false ;
    }
}
