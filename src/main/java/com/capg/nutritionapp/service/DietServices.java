package com.capg.nutritionapp.service;

import com.capg.nutritionapp.entity.DietPlan;
import com.capg.nutritionapp.exception.DietPlanNotFoundException;

import java.util.List;

public interface DietServices {

    public DietPlan createDietPlan(DietPlan dietPlan);

    public void changeDietPlan(long dietPlanId,String slots, String foodType,
                                   String userId,String proteinRatio, String fatRatio,
                                   String carbsRatio,String total) throws DietPlanNotFoundException;

    public void removeDietPlan(long dietPlanId) throws DietPlanNotFoundException;

    public List<DietPlan> listAllPlan();

}
