package com.capg.nutritionapp.service;

import com.capg.nutritionapp.entity.NutritionPlan;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public interface NutritionPlanService {
    @Autowired
    List<NutritionPlan> getNutritionPlans();

    Object addNewNutritionPlan(NutritionPlan nutritionPlan);

    void deleteNutritionPlan(Long nutritionPlanId);

    @Transactional
    void updateNutritionPlan(Long nutritionPlanId,
                             String name,
                             Double price, String planDiscription);
}
