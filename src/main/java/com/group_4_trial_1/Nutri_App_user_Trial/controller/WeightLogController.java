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

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< Updated upstream
//Description : This is WeightLog Controller
=======
//Description : This is Flat Controller
>>>>>>> Stashed changes
=======
//Description : This is weightLog Controller
>>>>>>> e0dffda6e325ff7fdfcea9e50c4b59640758274b
=======
//Description : This is weightLog Controller
>>>>>>> e0dffda6e325ff7fdfcea9e50c4b59640758274b

@RestController
@RequestMapping(path = "/weightLog")  
/*Spring RestController takes care of mapping request data 
* to the defined request handler method
*/ 
public class WeightLogController {
	private static final Logger logger = LogManager.getLogger(WeightLogController.class);
	
    private final WeightLogServiceImpl weightLogService;
    @Autowired
    public WeightLogController(WeightLogServiceImpl weightLogService) {
        this.weightLogService = weightLogService;
    }
    
    
//private Environment environment;
<<<<<<< HEAD
<<<<<<< HEAD
   @GetMapping
    public List<WeightLog> WeightLog() throws WeightLogNotFoundException {
       return weightLogService.showAllWeightLog();
  }
=======
  
>>>>>>> e0dffda6e325ff7fdfcea9e50c4b59640758274b
=======
  
>>>>>>> e0dffda6e325ff7fdfcea9e50c4b59640758274b

   /************************************************************************************
	 * Method: addWeightLog
	 * Description: It is used to add weight into weightLog table
	 * @PostMapping: It is used to handle the HTTP POST requests matched.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ************************************************************************************/


  @PostMapping
  public void addWeightLog(@RequestBody WeightLog weightLog) throws WeightLogNotFoundException{
        weightLogService.addWeightLog(weightLog);
  }
  
  /************************************************************************************
	 * Method: updateWeightLog
	 * Description: It is used to update weight which is already there in weightLog table
	 * @PutMapping: It is used to handle the HTTP PUT requests matched.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ************************************************************************************/
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> e0dffda6e325ff7fdfcea9e50c4b59640758274b

=======

>>>>>>> e0dffda6e325ff7fdfcea9e50c4b59640758274b

  @PutMapping(path ="{ID}")
  public void updateWeightLog(@RequestBody WeightLog weightLog,
          @PathVariable("ID") Long ID,
@RequestParam(required = false) String userId 
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


  /************************************************************************************
	 * Method: removeWeightLog
	 * Description: It is used to remove Weight from WeightLog table
	 * @DeleteMapping: It is used to handle the HTTP DELETE requests matched.
	 *  
	 ************************************************************************************/
	
  
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
  /************************************************************************************
	 * Method: showAllWeightLog
	 * Description: It is used to show all weights  from weightLog  table
<<<<<<< HEAD
<<<<<<< HEAD
	 * @returns flat :It returns weightLog table with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched.
	 *  
	 ************************************************************************************/

=======
=======
>>>>>>> e0dffda6e325ff7fdfcea9e50c4b59640758274b
	 * @returns WeightLog :It returns weightLog table with details
	 * @GetMapping: It is used to handle the HTTP GET requests matched.
	 *  
	 ************************************************************************************/
  @GetMapping
  public List<WeightLog> WeightLog() throws WeightLogNotFoundException {
     return weightLogService.showAllWeightLog();
}
<<<<<<< HEAD
>>>>>>> e0dffda6e325ff7fdfcea9e50c4b59640758274b
=======
>>>>>>> e0dffda6e325ff7fdfcea9e50c4b59640758274b
}



