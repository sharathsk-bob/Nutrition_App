package com.capg.nutritionapp.service;

import java.util.List;
import javax.transaction.Transactional;
import com.capg.nutritionapp.entity.NutritionPlan;

/**
 * The Interface IAppointmentService.
 */
public interface INutritionPlanService {
    
	/**
	 * Gets the Nutrition Plans.
	 * @return the all Nutrition Plans
	 */
    public List<NutritionPlan> getNutritionPlans();
    
    /**
	 * Adds the New Nutrition Plan.
	 *
	 * @param NutritionPlanDTO the NutritionPlan DTO
	 * @return the NutritionPlan DTO
	 * @throws NutritionPlan the nutritionplan exception
	 */
    public Object addNewNutritionPlan(NutritionPlan nutritionPlan);
    
    /**
	 * Removes the NutritionPlan.
	 *
	 * @param NutritionPlanDTO the NutritionPlan DTO
	 * @return the NutritionPlan DTO
	 * @throws NutritionPlan the nutritionplan exception
	 */
    public void deleteNutritionPlan(long nutritionPlanId);
    
    /**
	 * Update NutritionPlan.
	 *
	 * @param NutritionPlanDTO the NutritionPlan DTO
	 * @return the NutritionPlan DTO
	 * @throws NutritionPlan the nutritionplan exception
	 */
   
    @Transactional
    public void updateNutritionPlan(long nutritionPlanId,String name,
                             Double price, String planDiscription);
}
