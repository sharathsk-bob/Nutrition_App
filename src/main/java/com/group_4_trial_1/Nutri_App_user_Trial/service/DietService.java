package com.group_4_trial_1.Nutri_App_user_Trial.service;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.DietPlan;
import com.group_4_trial_1.Nutri_App_user_Trial.exception.DietPlanNotFoundException;
import com.group_4_trial_1.Nutri_App_user_Trial.repository.DietPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DietService implements DietServices {
    private final DietPlanRepo dietPlanRepo;
    @Autowired
    public DietService(DietPlanRepo dietPlanRepo) {
        this.dietPlanRepo = dietPlanRepo;
    }

    public List<DietPlan>  listAllPlan(){
    return dietPlanRepo.findAll();
    }

    public DietPlan createDietPlan(DietPlan dietPlan) {
//        Optional<DietPlan> dietById= dietPlanRepo.findDietPlanById(dietPlan.getId());
//        if(dietById.isPresent()){
//            throw new IllegalStateException("plan alrady exists");
//        }
        DietPlan diet = dietPlanRepo.save(dietPlan);
       return  diet;
    }

    public void removeDietPlan(int dietPlanId) throws DietPlanNotFoundException {
boolean exists = dietPlanRepo.existsById(dietPlanId);
if(!exists){
    throw new DietPlanNotFoundException("The id mentioned" + dietPlanId + "doesn't exists");
}dietPlanRepo.deleteById(dietPlanId);
    }
@Transactional
    public DietPlan changeDietPlan(DietPlan dietPlan, int dietPlanId) throws DietPlanNotFoundException
    {

            DietPlan value = dietPlanRepo.findById(dietPlanId).
                    orElseThrow(()->new DietPlanNotFoundException("DietPlan with id "+
                            dietPlanId +" does not exist."));
            value.setCarbsRatio(dietPlan.getCarbsRatio());
            value.setFatRatio(dietPlan.getFatRatio());
            value.setFoodType(dietPlan.getFoodType());
            value.setSlots(dietPlan.getSlots());
            value.setTotal(dietPlan.getTotal());
            value.setProteinRatio(dietPlan.getProteinRatio());
            return dietPlanRepo.save(value);
    }
}
