package com.sportTogether.SportTogether.service.imp;

import com.sportTogether.SportTogether.dto.YardsDTO;
import com.sportTogether.SportTogether.entity.Yards;
import com.sportTogether.SportTogether.repository.YardsRepository;
import com.sportTogether.SportTogether.service.YardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YardsServiceImp implements YardsService {

    @Autowired
    YardsRepository yardsRepository;

    private YardsDTO changeToDto (Yards yard)
    {
        YardsDTO yardsDTO = new YardsDTO();
        yardsDTO.setId(yard.getId());
        yardsDTO.setName(yard.getName());
        yardsDTO.setDescription(yard.getDescription());
        yardsDTO.setAddress(yard.getAddress());
        yardsDTO.setDistance(yard.getDistance());
        yardsDTO.setPrice(yard.getPrice());
        yardsDTO.setStars(yard.getStars().getQuantities());
        yardsDTO.setType(yard.getType());
        return yardsDTO;
    }

    @Override
    public YardsDTO getYardById(int id) {
        try
        {
            Yards yard = yardsRepository.findById(id);
            YardsDTO yardsDTO = changeToDto(yard);
            return yardsDTO;
        }catch ( Exception e )
        {
            System.out.println("Error in getYardById method (YardsServiceImp) " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<YardsDTO> getAllYards() {
        List<YardsDTO> yardsDTOS = new ArrayList<>();
        List<Yards> yards = yardsRepository.findAll();
        for (Yards yard :yards
             ) {
            YardsDTO yardsDTO = changeToDto(yard);
            yardsDTOS.add(yardsDTO);
        }
        return yardsDTOS;
    }

    @Override
    public List<YardsDTO> filterByType(String type) {
        List<Yards>yards = yardsRepository.filterByType(type);
        List<YardsDTO>yardsDTOS = new ArrayList<>();
        if (!yards.isEmpty())
        {
            for (Yards yard :yards
            ) {
                YardsDTO yardsDTO = changeToDto(yard);
                yardsDTOS.add(yardsDTO);
            }
        }
        return yardsDTOS;
    }

    @Override
    public List<YardsDTO> filterByStars(int type) {
        List<Yards>yards = yardsRepository.filterByStars(type);
        List<YardsDTO>yardsDTOS = new ArrayList<>();
        if (!yards.isEmpty())
        {
            for (Yards yard :yards
            ) {
                YardsDTO yardsDTO = changeToDto(yard);
                yardsDTOS.add(yardsDTO);
            }
        }
        return yardsDTOS;
    }
}
