package com.capg.nutritionapp.repository;

import com.capg.nutritionapp.entity.NutritionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
  * Version : 1.0
 * Date : 19-10-2022
 * Description : This is NutritionPlanRepository.
*/

/*Repository  is used to indicate that the class provides the mechanism 
 * for storage, retrieval, search, update and delete operation on objects*/
@Repository
public interface NutritionPlanRepository
        extends JpaRepository<NutritionPlan, Long> {

    // SELECT * FROM nutrition_planDTO where email= XYZ ;
    // @Query("SELECT n FROM nutrition_planDTO n where n.price= ?1")
    //Optional<NutritionPlanDTO> findNutritionPlanDTOByPrice(Double price);
}
