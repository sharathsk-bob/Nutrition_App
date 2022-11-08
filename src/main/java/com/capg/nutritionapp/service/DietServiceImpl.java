package com.capg.nutritionapp.service;

import com.capg.nutritionapp.dto.DietPlanDTO;
import com.capg.nutritionapp.entity.DietPlan;
import com.capg.nutritionapp.exception.DietPlanNotFoundException;

import com.capg.nutritionapp.repository.DietPlanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DietServiceImpl implements IDietService {
    private static final Logger logger = LogManager.getLogger(DietServiceImpl.class);
    private final DietPlanRepository dietPlanRepo;
    @Autowired
    public DietServiceImpl(DietPlanRepository dietPlanRepo) {
        this.dietPlanRepo = dietPlanRepo;
    }

    public List<DietPlan>  listAllPlan(){
        logger.info("listAllPlan method initiated.");
    return dietPlanRepo.findAll();
    }

    public DietPlanDTO createDietPlan(DietPlanDTO dietPlanDTO) {
        logger.info("createDietPlan method initiated");
        DietPlanDTO dietDTO = dietPlanRepo.save(dietPlanDTO);
        logger.info("createDietPlan method executed");
       return  dietDTO;
    }

    public DietPlanDTO removeDietPlan(long dietPlanId)  throws DietPlanNotFoundException{
        logger.info("removeDietPlan method initiated");
        boolean exists = dietPlanRepo.existsById(dietPlanId);
        if(!exists){
            throw new DietPlanNotFoundException("The id mentioned" + dietPlanId + "doesn't exists");
        }dietPlanRepo.deleteById(dietPlanId);
        logger.info("removeDietPlan method executed");
		return null;
    }


@Transactional
    public DietPlanDTO changeDietPlan(long id, DietPlanDTO DietPlanDTO) throws DietPlanNotFoundException
    {
        logger.info("changeDietPlan method initiated.");

            DietPlan value = dietPlanRepo.findDietPlanById(id).
                    orElseThrow(()->new DietPlanNotFoundException("DietPlan with id does not exist."));
            value.setCarbsRatio(DietPlanDTO.getCarbsRatio());
            value.setFatRatio(DietPlanDTO.getFatRatio());
            value.setFoodType(DietPlanDTO.getFoodType());
            value.setProteinRatio(DietPlanDTO.getProteinRatio());
            value.setSlots(DietPlanDTO.getSlots());
            //value.setUserId(userId);
            value.setTotal(DietPlanDTO.getTotal());

        logger.info("changeDietPlan method executed");
		return DietPlanDTO;

    }
}

