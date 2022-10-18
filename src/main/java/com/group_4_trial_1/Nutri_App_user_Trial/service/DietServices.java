package com.group_4_trial_1.Nutri_App_user_Trial.service;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.DietPlan;
import com.group_4_trial_1.Nutri_App_user_Trial.exception.DietPlanNotFoundException;

import java.util.List;

public interface DietServices {

    public DietPlan createDietPlan(DietPlan dietPlan);

    public DietPlan changeDietPlan(DietPlan dietPlan, int dietPlanId) throws DietPlanNotFoundException;

    public void removeDietPlan(int dietPlanId) throws DietPlanNotFoundException;

    public List<DietPlan> listAllPlan();

}
