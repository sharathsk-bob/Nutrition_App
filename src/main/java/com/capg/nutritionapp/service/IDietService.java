package com.capg.nutritionapp.service;

import java.util.List;
import com.capg.nutritionapp.dto.DietPlanDTO;
import com.capg.nutritionapp.entity.DietPlan;
import com.capg.nutritionapp.exception.DietPlanNotFoundException;

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
    public DietPlanDTO createDietPlan(DietPlanDTO dietPlanDTO);
    
    /**
	 * Update/Change DietPlan.
	 * @param DietPlanDTO the DietPlan DTO
	 * @return the DietPlan DTO
	 * @throws DietPlanException the DietPlanNotFound exception
	 */
    public DietPlanDTO changeDietPlan(long dietPlanId,DietPlanDTO dietplanDTO) throws DietPlanNotFoundException;
    
    /**
	 * Removes the DietPlan.
	 * @param DietPlanDTO the DietPlan DTO
	 * @return the DietPlan DTO
	 * @throws DietPlanException the DietPlanNotFound exception
	 */
    public DietPlanDTO removeDietPlan(long dietPlanId) throws DietPlanNotFoundException;
    
    /**
	 * Gets and lists the all DietPlan.
	 * @return the all DietPlan
	 */
    public List<DietPlan> listAllPlan();

}
