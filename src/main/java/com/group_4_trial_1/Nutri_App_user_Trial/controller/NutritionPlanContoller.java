package com.group_4_trial_1.Nutri_App_user_Trial.controller;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.NutritionPlan;
import com.group_4_trial_1.Nutri_App_user_Trial.service.NutritionPlanService;
import com.group_4_trial_1.Nutri_App_user_Trial.service.NutritionPlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Description : This is Nutrition Plan Controller

@RestController
@RequestMapping(path = "nutritionplan")
/* Spring RestController takes care of mapping request data 
 to the defined request handler method */ 
public class NutritionPlanContoller {

    private final NutritionPlanServiceImpl nutritionPlanService;

    @Autowired
    public NutritionPlanContoller(NutritionPlanServiceImpl nutritionPlanService) {
        this.nutritionPlanService = nutritionPlanService;
    }

    /************************************************************************************
	 * Method: listAllPlans
	 * Description: It is used to show all Nutrition Plans  from nutrition_plan  table
<<<<<<< HEAD
	 * @returns flat :It returns nutrition_plan table with details
=======
	 * @returns plan :It returns nutrition_plan table with details
>>>>>>> e0dffda6e325ff7fdfcea9e50c4b59640758274b
	 * @GetMapping: It is used to handle the HTTP GET requests matched.
	 *  
	 ************************************************************************************/
    @GetMapping
    public List<NutritionPlan> listAllPlans(){
   // throw new NutritionPlanApiRequestException("Oops cannot get all Nutrition Plans with custom exception");
    //throw new IllegalStateException("Oops cannot get all Nutrition Plans");
       return  nutritionPlanService.getNutritionPlans();
    }
    
    /************************************************************************************
	 * Method: createPlan
	 * Description: It is used to add nutrition plan into nutrition_plan table
	 * @PostMapping: It is used to handle the HTTP POST requests matched.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ************************************************************************************/

    @PostMapping
    public void createPlan(@RequestBody NutritionPlan nutritionPlan){
        nutritionPlanService.addNewNutritionPlan(nutritionPlan);
    }
    
      /************************************************************************************
	 * Method: removePlan
	 * Description: It is used to remove Nutrition Plan from nutrition_plan table
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched.
	 *  
	 ************************************************************************************/
    
    @DeleteMapping(path = "{nutritionPlanDTOId}")
    public void removePlan(
            @PathVariable("nutritionPlanDTOId") Long nutritionPlanDTOId){
        nutritionPlanService.deleteNutritionPlan(nutritionPlanDTOId);
    }

    /************************************************************************************
	 * Method: changePlan
	 * Description: It is used to update nutrition Plan which is already there in nutrition_plan table
	 * @PutMapping: It is used to handle the HTTP PUT requests matched.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ************************************************************************************/
    
    @PutMapping(path = "{nutritionPlanDTOId}")
    public void changePlan(
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
