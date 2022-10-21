package com.capg.nutritionapp.service;

import com.capg.nutritionapp.entity.NutritionPlan;
import com.capg.nutritionapp.repository.NutritionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

//Description : This is Nutrition Plan Service Layer

@Service
public class NutritionPlanServiceImpl implements NutritionPlanService {

    private final NutritionPlanRepository nutritionPlanRepository;

    public NutritionPlanServiceImpl(NutritionPlanRepository nutritionPlanRepository) {
        this.nutritionPlanRepository = nutritionPlanRepository;
    }

    /*
 * Description : This method shows existing Nutrition Plans :Input Parameter 
 *          
 */
    @Override
    @Autowired
    public List<NutritionPlan> getNutritionPlans(){
        return nutritionPlanRepository.findAll();
    }

    
  //Description : This method Adds new NutritionPlan : Input Parameter
    
    @Override
    public Object addNewNutritionPlan(NutritionPlan nutritionPlan) {
   /*    Optional<NutritionPlanDTO> findNutritionPlanDTOByEmail = nutritionPlanRepository.
                findNutritionPlanDTOByEmail(nutritionPlanDTO.getEmail())
        if(nutritionPlanDTOOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }*/
        nutritionPlanRepository.save(nutritionPlan);
//        System.out.println(nutritionPlan);
        return null;
    }

    /*
 * Description : This method removes existing ID :Input Parameter 
 *               Throws Exception if the ID is not found as NutritionPlanNotFoundException
 */

    @Override
    public void deleteNutritionPlan(Long nutritionPlanId) {
         boolean exists = nutritionPlanRepository.existsById(nutritionPlanId);
         if(!exists){
             throw new IllegalStateException("Nutrition Plan for id "
                     + nutritionPlanId + " does not exits");
         }
         nutritionPlanRepository.deleteById(nutritionPlanId);
    }

    
    /*
	 * Description : This method Updates existing Nutrition Plan by taking ID:Input Parameter 
	 *               Throws Exception if the ID is not found as NutritionPlanNotFoundException	
	 */
    
    @Override
    @Transactional
    public void updateNutritionPlan(Long nutritionPlanId,
                                    String name,
                                    Double price, String planDiscription) {
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
    }
}
