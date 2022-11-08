package com.capg.nutritionapp.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.nutritionapp.dto.DietPlanDTO;
import com.capg.nutritionapp.entity.DietPlan;
import com.capg.nutritionapp.service.DietServiceImpl;

@RestController
@RequestMapping(path = "/dietPlan")
public class DietController {
    private static final Logger logger = LogManager.getLogger(DietController.class);
    private final DietServiceImpl dietService;
    @Autowired
    public DietController(DietServiceImpl dietService) {
        this.dietService = dietService;
    }

    @GetMapping(path = "/showPlans")
    public List<DietPlan> DietPlan(){

        return dietService.listAllPlan();
  }


  @PostMapping(path = "/create")
  public DietPlanDTO createDietPlan(@RequestBody DietPlanDTO dietPlan){
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
            @PathVariable(" dietPlanId") long  dietPlanId
           // @RequestParam(required = false) 
            )
    {
        try{
        dietService.changeDietPlan(dietPlanId);}
    catch(Exception e)
    {
        logger.info("The plan you are requesting to change doesn't exists");
    }
    }

}
