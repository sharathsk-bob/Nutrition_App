package com.group_4_trial_1.Nutri_App_user_Trial.service;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.NutritionPlan;
import com.group_4_trial_1.Nutri_App_user_Trial.repository.NutritionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Service
public class NutritionPlanService {

//  private Logger logger;
    private final NutritionPlanRepository nutritionPlanRepository;

    public NutritionPlanService(NutritionPlanRepository nutritionPlanRepository) {
        this.nutritionPlanRepository = nutritionPlanRepository;
    }

    @Autowired
    public List<NutritionPlan> listAllPlans(){
    //	logger.info("Getting all Nutrition Plans...");
        return nutritionPlanRepository.findAll();
    }

    public NutritionPlan createPlan(NutritionPlan nutritionPlan) {
   /*    Optional<NutritionPlanDTO> findNutritionPlanDTOByEmail = nutritionPlanRepository.
                findNutritionPlanDTOByEmail(nutritionPlanDTO.getEmail())
        if(nutritionPlanDTOOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }*/
    	return nutritionPlanRepository.save(nutritionPlan);
//        System.out.println(nutritionPlan);
       
    }


    public void removePlan(Long nutritionPlanId) {
         boolean exists = nutritionPlanRepository.existsById(nutritionPlanId);
         if(!exists){
             throw new IllegalStateException("Nutrition Plan for id "
                     + nutritionPlanId + " does not exits");
         }
         nutritionPlanRepository.deleteById(nutritionPlanId);
    }

    @Transactional
    public NutritionPlan changePlan(Long nutritionPlanId,
                                       String name,
                                       Double price , String planDiscription ) {
        NutritionPlan nutritionPlanDTO = nutritionPlanRepository.findById(nutritionPlanId).
                orElseThrow(() -> new IllegalStateException(
                        "Nutrition Plan with id " + nutritionPlanId + " does not exists"));
                if(name != null && name.length() > 0 &&
                !Objects.equals(nutritionPlanDTO.getName(),name)){
                    nutritionPlanDTO.setName(name);
                }
        if(price!= null  &&
                !Objects.equals(nutritionPlanDTO.getPrice(),price)){
            nutritionPlanDTO.setPrice(price);
        }
        if(planDiscription!= null  &&
                !Objects.equals(nutritionPlanDTO.getPlanDiscription(),planDiscription)){
            nutritionPlanDTO.setPlanDiscription(planDiscription);
        }
       /*  if(created_At!= null  &&
                !Objects.equals(nutritionPlanDTO.getCreated_At(),created_At)){
            nutritionPlanDTO.setCreated_At(created_At);
        }
        if(updated_At!= null  &&
                !Objects.equals(nutritionPlanDTO.getUpdated_At(),updated_At)){
            nutritionPlanDTO.setUpdated_At(updated_At);
        }*/
        return nutritionPlanDTO;
    }
}
