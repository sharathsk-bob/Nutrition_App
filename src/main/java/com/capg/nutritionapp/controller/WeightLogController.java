package com.capg.nutritionapp.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.capg.nutritionapp.entity.WeightLog;
import com.capg.nutritionapp.exception.WeightLogNotFoundException;
import com.capg.nutritionapp.service.WeightLogServiceImpl;

@RestController
@RequestMapping(path = "/weightLog") 
@CrossOrigin(origins = "http://localhost:3000")
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

   @GetMapping(path="/showAllWeightLog")
    public List<WeightLog> WeightLog() {
       return weightLogService.showAllWeightLog();
  }


   /************************************************************************************
	 * Method: addWeightLog
	 * Description: It is used to add weight into weightLog table
	 * @PostMapping: It is used to handle the HTTP POST requests matched.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ************************************************************************************/


  @PostMapping(path="/addWeightLog")
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


  @PutMapping(path ="/updateWeightLog/{ID}")
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
	
  
  @DeleteMapping(path ="/addWeightLog/{ID}")
  public void removeWeightLog(@PathVariable("ID") Long ID  ){
        /*try {
            WeightLogServices.removeWeightLog(weight);
        }catch(Exception e){
            System.out.println("Please enter correct WeightLog Id.");
        }*/

	  //WeightLogServiceImpl weightLogServices ;
			// @DeleteMapping(path = "{id}")
        //public void deleteUser(@PathVariable("id") Long id) {
 
        try{
        	weightLogService.removeWeightLog(ID);}
        catch(Exception e)
        {
      	  logger.info("The plan you are requesting to update doesn't exists");
        }
  }
}



