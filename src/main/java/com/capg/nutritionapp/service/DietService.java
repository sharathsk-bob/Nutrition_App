package com.capg.nutritionapp.service;

import com.capg.nutritionapp.entity.DietPlan;
import com.capg.nutritionapp.exception.DietPlanNotFoundException;
import com.capg.nutritionapp.repository.DietPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DietService implements DietServices {
    private static final Logger logger = LogManager.getLogger(DietService.class);
    private final DietPlanRepo dietPlanRepo;
    @Autowired
    public DietService(DietPlanRepo dietPlanRepo) {
        this.dietPlanRepo = dietPlanRepo;
    }

    public List<DietPlan>  listAllPlan(){
        logger.info("listAllPlan method initiated.");
    return dietPlanRepo.findAll();
    }

    public DietPlan createDietPlan(DietPlan dietPlan) {
        logger.info("createDietPlan method initiated");
        DietPlan diet = dietPlanRepo.save(dietPlan);
        logger.info("createDietPlan method executed");
       return  diet;
    }

    public void removeDietPlan(long dietPlanId)  throws DietPlanNotFoundException{
        logger.info("removeDietPlan method initiated");
        boolean exists = dietPlanRepo.existsById(dietPlanId);
        if(!exists){
            throw new DietPlanNotFoundException("The id mentioned" + dietPlanId + "doesn't exists");
        }dietPlanRepo.deleteById(dietPlanId);
        logger.info("removeDietPlan method executed");
    }


@Transactional
    public void changeDietPlan(long dietPlanId,String slots, String foodType,
                                   String userId,String proteinRatio, String fatRatio,
                                   String carbsRatio,String total) throws DietPlanNotFoundException
    {
        logger.info("changeDietPlan method initiated.");

            DietPlan value = dietPlanRepo.findById(dietPlanId).
                    orElseThrow(()->new DietPlanNotFoundException("DietPlan with id "+
                            dietPlanId +" does not exist."));
            value.setCarbsRatio(carbsRatio);
            value.setFatRatio(fatRatio);
            value.setFoodType(foodType);
            value.setProteinRatio(proteinRatio);
            value.setSlots(slots);
            value.setUserId(userId);
            value.setTotal(total);

        logger.info("changeDietPlan method executed");

    }
}
