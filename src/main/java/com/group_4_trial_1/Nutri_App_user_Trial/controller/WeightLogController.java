package com.group_4_trial_1.Nutri_App_user_Trial.controller;

//import com.nutritionapp.nutrition.Entity.WeightLog;
//import com.nutritionapp.nutrition.service.WeightLogService;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.WeightLog;
import com.group_4_trial_1.Nutri_App_user_Trial.exception.WeightLogNotFoundException;
import com.group_4_trial_1.Nutri_App_user_Trial.service.WeightLogServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(path = "/weightLog")
public class WeightLogController {
	private static final Logger logger = LogManager.getLogger(WeightLogController.class);
	
    private final WeightLogServiceImpl weightLogService;
    @Autowired
    public WeightLogController(WeightLogServiceImpl weightLogService) {
        this.weightLogService = weightLogService;
    }


//private Environment environment;
   @GetMapping
    public List<WeightLog> WeightLog() throws WeightLogNotFoundException {
       return weightLogService.showAllWeightLog();
  }




  @PostMapping
  public void addWeightLog(@RequestBody WeightLog weightLog) throws WeightLogNotFoundException{
        weightLogService.addWeightLog(weightLog);
  }

  @PutMapping(path ="ID")
  public void updateWeightLog(@RequestBody WeightLog weightLog,
          @PathVariable("ID") Long ID
//@RequestParam(required = false) String slots ,
//@RequestParam(required = false) String foodType
)
  {
      try{
    	  weightLogService.updateWeightLog(weightLog, ID);}
  catch(Exception e)
  {
	  logger.info("The plan you are requesting to update doesn't exists");
  }
  }


  @DeleteMapping(path ="{ID}")
  public void removeWeightLog(@PathVariable("ID") Long ID  ){
        /*try {
            WeightLogServices.removeWeightLog(weight);
        }catch(Exception e){
            System.out.println("Please enter correct WeightLog Id.");
        }*/

	  //WeightLogServiceImpl weightLogServices ;
			// @DeleteMapping(path = "{id}")
        //public void deleteUser(@PathVariable("id") Long id) {
	 
        

 
    {
        try{
        	weightLogService.removeWeightLog(ID);}
    catch(Exception e)
    {
    	logger.info("The log you are requesting to update doesn't exists");
    }
    }

  }
}



