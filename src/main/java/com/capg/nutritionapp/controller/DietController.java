package com.capg.nutritionapp.controller;

import com.capg.nutritionapp.entity.DietPlan;
import com.capg.nutritionapp.service.DietService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/dietPlan")
public class DietController {
    private static final Logger logger = LogManager.getLogger(DietController.class);
    private final DietService dietService;
    @Autowired
    public DietController(DietService dietService) {
        this.dietService = dietService;
    }

    @GetMapping(path = "/showPlans")
    public List<DietPlan> DietPlan(){

        return dietService.listAllPlan();
  }


  @PostMapping(path = "/create")
  public DietPlan createDietPlan(@RequestBody DietPlan dietPlan){
        //dietService.createDietPlan(dietPlan);
        return dietService.createDietPlan(dietPlan);
  }


    @DeleteMapping(path ="/delete/{dietPlanId}")
    public void removeDietPlan(@PathVariable("dietPlanId") int dietPlanId){
        try {
            dietService.removeDietPlan( dietPlanId);
        }catch(Exception e){
            logger.info("Please enter correct dietPlan Id.");
        }}


        @PutMapping(path ="/change/{dietPlanId}")
    public void changeDietPlan(
            @PathVariable(" dietPlanId") long  dietPlanId,
                               @RequestParam(required = false) String slots ,
                               @RequestParam(required = false) String foodType,
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) String proteinRatio,
            @RequestParam(required = false) String fatRatio,
            @RequestParam(required = false) String carbsRatio,
            @RequestParam(required = false) String total
    )
    {
        try{
        dietService.changeDietPlan( dietPlanId,slots,foodType
                ,proteinRatio,fatRatio,carbsRatio,total);}
    catch(Exception e)
    {
        logger.info("The plan you are requesting to change doesn't exists");
    }
    }

}
