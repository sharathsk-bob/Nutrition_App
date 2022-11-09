package com.capg.nutritionapp.service;

import java.util.List;
import javax.transaction.Transactional;

import com.capg.nutritionapp.dto.NutritionPlanDTO;
import com.capg.nutritionapp.entity.NutritionPlan;
import com.capg.nutritionapp.exception.InvalidDataException;

/**
 * The Interface IAppointmentService.
 */
public interface INutritionPlanService {
    
	/**
	 * Gets the Nutrition Plans.
	 * @return the all Nutrition Plans
	 */
    public List<NutritionPlanDTO> getNutritionPlans() throws InvalidDataException;
    
    /**
	 * Adds the New Nutrition Plan.
	 *
	 * @param NutritionPlanDTO the NutritionPlan DTO
	 * @return the NutritionPlan DTO
	 * @throws NutritionPlan the nutritionplan exception
	 */
    public NutritionPlan addNewNutritionPlan(NutritionPlan nutritionPlan)throws InvalidDataException;
    
    /**
	 * Removes the NutritionPlan.
	 *
	 * @param NutritionPlanDTO the NutritionPlan DTO
	 * @return the NutritionPlan DTO
	 * @throws NutritionPlan the nutritionplan exception
	 */
    public NutritionPlanDTO deleteNutritionPlan(long nutritionPlanId)throws InvalidDataException;
    
    /**
	 * Update NutritionPlan.
	 *
	 * @param NutritionPlanDTO the NutritionPlan DTO
	 * @return the NutritionPlan DTO
	 * @throws NutritionPlan the nutritionplan exception
	 */
   
    @Transactional
    public NutritionPlanDTO updateNutritionPlan(NutritionPlanDTO nutritionPlan)throws InvalidDataException;
}