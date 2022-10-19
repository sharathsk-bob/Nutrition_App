package com.group_4_trial_1.Nutri_App_user_Trial.service;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.DietPlan;
import com.group_4_trial_1.Nutri_App_user_Trial.exception.DietPlanNotFoundException;

import java.util.List;

public interface DietServices {

    public DietPlan createDietPlan(DietPlan dietPlan);

    public void changeDietPlan(long dietPlanId,String slots, String foodType,
                                   String userId,String proteinRatio, String fatRatio,
                                   String carbsRatio,String total) throws DietPlanNotFoundException;

    public void removeDietPlan(long dietPlanId) throws DietPlanNotFoundException;

    public List<DietPlan> listAllPlan();

}
