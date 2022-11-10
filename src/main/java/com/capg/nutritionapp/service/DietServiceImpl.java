package com.capg.nutritionapp.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.nutritionapp.dto.DietPlanDTO;
import com.capg.nutritionapp.entity.DietPlan;
import com.capg.nutritionapp.exception.DietPlanNotFoundException;
import com.capg.nutritionapp.repository.DietPlanRepository;

@Service
public class DietServiceImpl implements IDietService {
    private static final Logger logger = LogManager.getLogger(DietServiceImpl.class);
    
    @Autowired
    private DietPlanRepository dietPlanRepo;

//    public DietServiceImpl(DietPlanRepository dietPlanRepo) {
//        this.dietPlanRepo = dietPlanRepo;
//    }

    public Iterable<DietPlan>  listAllPlan(){
        logger.info("listAllPlan method initiated.");
    return dietPlanRepo.findAll();
    }

    public DietPlanDTO createDietPlan(DietPlanDTO dietPlanDTO) throws DietPlanNotFoundException {
    	Optional<DietPlan> optionalDietPlanDTO = dietPlanRepo.findById(dietPlanDTO.getId());
		if(!optionalDietPlanDTO.isEmpty()) {
			throw new DietPlanNotFoundException("Service.DietPlanDTO_FOUND");
		}
		DietPlanDTO c = new DietPlanDTO();
		c.setCarbsRatio(dietPlanDTO.getCarbsRatio());;
		c.setFatRatio(dietPlanDTO.getFatRatio());
        c.setFoodType(dietPlanDTO.getFoodType()); 
        c.setProteinRatio(dietPlanDTO.getProteinRatio());
        c.setSlots(dietPlanDTO.getSlots());
        c.setTotal(dietPlanDTO.getTotal());
		DietPlanDTO c2 = dietPlanRepo.save(c);
		return c2;
    }

    public DietPlanDTO removeDietPlan(long dietPlanId)  throws DietPlanNotFoundException{
        logger.info("removeDietPlan method initiated");
        Optional<DietPlan> dietPlan = dietPlanRepo.findById(dietPlanId);
		DietPlan DietPlanDTO = dietPlan.orElseThrow(() -> new DietPlanNotFoundException("Service.DietPlanDTO_NOT_FOUND"));
		DietPlanDTO deletedDiet = new DietPlanDTO(DietPlanDTO.getId(),
				DietPlanDTO.getCarbsRatio(),
				DietPlanDTO.getFatRatio(),DietPlanDTO.getFoodType(),
                DietPlanDTO.getProteinRatio(), DietPlanDTO.getSlots(), 
                DietPlanDTO.getTotal());
		return deletedDiet;
    }


@Transactional
    public DietPlanDTO changeDietPlan(DietPlanDTO DietPlanDTO) throws DietPlanNotFoundException
    {
        logger.info("changeDietPlan method initiated.");
        Optional<DietPlan> dietPlanDTO = dietPlanRepo.findById(DietPlanDTO.getId());
		DietPlan c = dietPlanDTO.orElseThrow(() -> new DietPlanNotFoundException("Service.DietPlanDTO_NOT_FOUND"));
		c.setCarbsRatio(DietPlanDTO.getCarbsRatio());;
		c.setFatRatio(DietPlanDTO.getFatRatio());
        c.setFoodType(DietPlanDTO.getFoodType()); 
        c.setProteinRatio(DietPlanDTO.getProteinRatio());
        c.setSlots(DietPlanDTO.getSlots());
        c.setTotal(DietPlanDTO.getTotal());
        logger.info("changeDietPlan method executed");
		return DietPlanDTO;
    }
}

