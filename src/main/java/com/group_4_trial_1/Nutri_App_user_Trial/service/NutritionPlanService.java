package com.group_4_trial_1.Nutri_App_user_Trial.service;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.NutritionPlan;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public interface NutritionPlanService {
    @Autowired
    List<NutritionPlan> getNutritionPlans();

    void addNewNutritionPlan(NutritionPlan nutritionPlan);

    void deleteNutritionPlan(Long nutritionPlanId);

    @Transactional
    void updateNutritionPlan(Long nutritionPlanId,
                             String name,
                             Double price, String planDiscription);
}
