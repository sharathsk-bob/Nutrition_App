package com.capg.nutritionapp.service;

import java.util.Objects;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.nutritionapp.entity.NutritionPlan;
import com.capg.nutritionapp.repository.NutritionPlanRepository;

//Description : This is Nutrition Plan Service Layer

@Service
public class NutritionPlanServiceImpl implements INutritionPlanService {

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
    public Iterable<NutritionPlan> getNutritionPlans(){
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
    public void deleteNutritionPlan(long nutritionPlanId) {
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
    public void updateNutritionPlan(long id,NutritionPlan nutritionPlanDetails) {
        NutritionPlan nutritionPlanDTO = nutritionPlanRepository.findById(id).
                orElseThrow(() -> new IllegalStateException(
                        "Nutrition Plan with id " +id + " does not exists"));
        //System.out.println(name+price+planDescription+nutritionPlanId);
       if(nutritionPlanDetails.getName() != null && nutritionPlanDetails.getName().length() > 0 && !Objects.equals(nutritionPlanDTO.getName(),nutritionPlanDetails.getName())){
                    nutritionPlanDTO.setName(nutritionPlanDetails.getName());
        }
       Object s=nutritionPlanDetails.getPrice();
        if(s!= null &&  !Objects.equals(nutritionPlanDTO.getPrice(),nutritionPlanDetails.getPrice())){
            nutritionPlanDTO.setPrice(nutritionPlanDetails.getPrice());
        }
        if(nutritionPlanDetails.getPlanDescription()!= null  && !Objects.equals(nutritionPlanDTO.getPlanDescription(),nutritionPlanDetails.getPlanDescription())){
            nutritionPlanDTO.setPlanDescription(nutritionPlanDetails.getPlanDescription());
        }
        if(nutritionPlanDetails.getCreated_At()!= null  && !Objects.equals(nutritionPlanDTO.getCreated_At(),nutritionPlanDetails.getCreated_At())){
            nutritionPlanDTO.setCreated_At(nutritionPlanDetails.getCreated_At());
        }
        if(nutritionPlanDetails.getUpdated_At()!= null  && !Objects.equals(nutritionPlanDTO.getUpdated_At(),nutritionPlanDetails.getUpdated_At())){

            nutritionPlanDTO.setUpdated_At(nutritionPlanDetails.getUpdated_At());
        }
        nutritionPlanRepository.save(nutritionPlanDTO);
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