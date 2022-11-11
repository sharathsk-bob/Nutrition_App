package com.capg.nutritionapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.nutritionapp.entity.NutritionPlan;
import com.capg.nutritionapp.service.NutritionPlanServiceImpl;

//Description : This is Nutrition Plan Controller

@RestController
@RequestMapping(path = "nutritionplan")
/* Spring RestController takes care of mapping request data 
 to the defined request handler method */ 
@CrossOrigin(origins = "http://localhost:3000")
public class NutritionPlanContoller {

    private final NutritionPlanServiceImpl nutritionPlanService;

    @Autowired
    public NutritionPlanContoller(NutritionPlanServiceImpl nutritionPlanService) {
        this.nutritionPlanService = nutritionPlanService;
    }

    /************************************************************************************
	 * Method: listAllPlans
	 * Description: It is used to show all Nutrition Plans  from nutrition_plan  table
	 * @returns flat :It returns nutrition_plan table with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched.
	 *  
	 ************************************************************************************/
    @GetMapping(value = "/listAllnutri")
    public Iterable<NutritionPlan> listAllPlans(){
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

    @PostMapping(value = "/createnutri")
    public void createPlan(@RequestBody NutritionPlan nutritionPlan){
        nutritionPlanService.addNewNutritionPlan(nutritionPlan);
    }
    
      /************************************************************************************
	 * Method: removePlan
	 * Description: It is used to remove Nutrition Plan from nutrition_plan table
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched.
	 *  
	 ************************************************************************************/
    
    @DeleteMapping(path = "/removenutri/{nutritionPlanDTOId}")
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
    
    @PutMapping(path = "changenutri/{nutritionPlanDTOId}")
    public String changePlan(
            @PathVariable("nutritionPlanDTOId") Long nutritionPlanDTOId ,
            @RequestBody NutritionPlan nutritionPlanDetails )
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) Double price,
//            @RequestParam(required = false) String planDiscription)
             {
    	//System.out.println(name+price+planDiscription+nutritionPlanDTOId);
        nutritionPlanService.updateNutritionPlan(nutritionPlanDTOId ,nutritionPlanDetails
                );
        return "updated";
             }
}


    
    
    