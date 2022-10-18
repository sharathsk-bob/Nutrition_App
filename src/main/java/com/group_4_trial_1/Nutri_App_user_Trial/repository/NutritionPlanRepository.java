package com.group_4_trial_1.Nutri_App_user_Trial.repository;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.NutritionPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutritionPlanRepository
        extends JpaRepository<NutritionPlan, Long> {

    // SELECT * FROM nutrition_planDTO where email= XYZ ;
    // @Query("SELECT n FROM nutrition_planDTO n where n.price= ?1")
    //Optional<NutritionPlanDTO> findNutritionPlanDTOByPrice(Double price);
}