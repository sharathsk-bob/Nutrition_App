package com.group_4_trial_1.Nutri_App_user_Trial.controller;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.NutritionPlan;
import com.group_4_trial_1.Nutri_App_user_Trial.service.NutritionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "nutritionplan")
public class NutritionPlanContoller {

    private final NutritionPlanService nutritionPlanService;

    @Autowired
    public NutritionPlanContoller(NutritionPlanService nutritionPlanService) {
        this.nutritionPlanService = nutritionPlanService;
    }

    @GetMapping
    public List<NutritionPlan> getNutritionPlans(){
   // throw new NutritionPlanApiRequestException("Oops cannot get all Nutrition Plans with custom exception");
    //throw new IllegalStateException("Oops cannot get all Nutrition Plans");
       return  nutritionPlanService.getNutritionPlans();
    }

    @PostMapping
    public void registerNewNutritionPlan(@RequestBody NutritionPlan nutritionPlan){
        nutritionPlanService.addNewNutritionPlan(nutritionPlan);
    }
    @DeleteMapping(path = "{nutritionPlanDTOId}")
    public void deleteNutritionPlanDTO(
            @PathVariable("nutritionPlanDTOId") Long nutritionPlanDTOId){
        nutritionPlanService.deleteNutritionPlan(nutritionPlanDTOId);
    }

    @PutMapping(path = "{nutritionPlanDTOId}")
    public void updateNutritionPlanDTO(
            @PathVariable("nutritionPlanDTOId") Long nutritionPlanDTOId ,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String planDiscription,

           // @RequestParam(required = false) LocalDate created_At,
            //@RequestParam(required = false) LocalDate updated_At,

            @RequestParam(required = false) Double price) {
        nutritionPlanService.updateNutritionPlan(nutritionPlanDTOId ,name
                ,price,planDiscription);
    }
}
