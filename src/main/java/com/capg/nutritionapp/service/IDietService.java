package com.capg.nutritionapp.service;

import com.capg.nutritionapp.entity.DietPlan;
import com.capg.nutritionapp.exception.DietPlanNotFoundException;
import java.util.List;

/**
 * The Interface IDietService.
 */
public interface IDietService {

	/**
	 * Adds/Creates the Diet.
	 * @param DietPlanDTO the DietPlan DTO
	 * @return the DietPlan DTO
	 * @throws DietPlanException the DietPlan exception
	 */
    public DietPlan createDietPlan(DietPlan dietPlan);
    
    /**
	 * Update/Change DietPlan.
	 * @param DietPlanDTO the DietPlan DTO
	 * @return the DietPlan DTO
	 * @throws DietPlanException the DietPlanNotFound exception
	 */
    public void changeDietPlan(long dietPlanId,String slots, String foodType,
                                   String userId,String proteinRatio, String fatRatio,
                                   String carbsRatio,String total) throws DietPlanNotFoundException;
    
    /**
	 * Removes the DietPlan.
	 * @param DietPlanDTO the DietPlan DTO
	 * @return the DietPlan DTO
	 * @throws DietPlanException the DietPlanNotFound exception
	 */
    public void removeDietPlan(long dietPlanId) throws DietPlanNotFoundException;
    
    /**
	 * Gets and lists the all DietPlan.
	 * @return the all DietPlan
	 */
    public List<DietPlan> listAllPlan();

}
