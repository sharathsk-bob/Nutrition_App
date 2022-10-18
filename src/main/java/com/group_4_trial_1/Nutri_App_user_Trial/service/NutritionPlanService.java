package com.example.demo.service;

import com.example.demo.entity.NutritionPlanDTO;
import com.example.demo.exception.NutritionPlanNotFoundException;
import java.util.List;

public interface NutritionPlanService {

    public NutritionPlanDTO createPlan(NutritionPlanDTO nutritionPlanDTO);

    public NutritionPlanDTO changePlan(Long nutritionPlanDTOId,
                                                   String name,
                                                   Double price , String planDescription ) throws NutritionPlanNotFoundException;

    public void removePlan(Long nutritionPlanDTOId) throws NutritionPlanNotFoundException;

    public List<NutritionPlanDTO> listAllPlans();
}
