package com.group_4_trial_1.Nutri_App_user_Trial.repository;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.NutritionPlan;
import org.springframework.data.jpa.repository.JpaRepository;


/*
 * Author : B K Mohammed Kamran
 * Version : 1.0
 * Date : 19-10-2022
 * Description : This is NutritionPlanRepository.
*/

/*Repository  is used to indicate that the class provides the mechanism 
 * for storage, retrieval, search, update and delete operation on objects*/

public interface NutritionPlanRepository
        extends JpaRepository<NutritionPlan, Long> {

    // SELECT * FROM nutrition_planDTO where email= XYZ ;
    // @Query("SELECT n FROM nutrition_planDTO n where n.price= ?1")
    //Optional<NutritionPlanDTO> findNutritionPlanDTOByPrice(Double price);
}
