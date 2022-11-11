package com.capg.nutritionapp.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.capg.nutritionapp.exception.DietPlanNotFoundException;
import com.capg.nutritionapp.service.DietServiceImpl;


@RestController
@RequestMapping(path = "/dietPlan")
@CrossOrigin(origins = "http://localhost:3000")
public class DietController {
    //private static final Logger logger = LogManager.getLogger(DietController.class);
    @Autowired
    private DietServiceImpl dietService;
     
    @Autowired
 	private Environment environment;
    
    /************************************************************************************
     * Method: listAllPlan
     * Description: It is used to get all diet plans from dietplan_table
     * @GetMapping: It is used to handle the HTTP GET requests matched.
     ************************************************************************************/
    @GetMapping(path = "/showPlans")
    public Iterable<DietPlan> DietPlan(){
      return dietService.listAllPlan();
  }

    /************************************************************************************
     * Method: createDietPlan
     * Description: It is used to add dietPlan into dietPlan_table
     * @PostMapping: It is used to handle the HTTP POST requests matched.
     * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
     *
     ************************************************************************************/
    @PostMapping(path = "/create")
    public ResponseEntity<String> createDietPlan(@Valid @RequestBody DietPlanDTO dietPlan)throws DietPlanNotFoundException{
        DietPlanDTO dp = dietService.createDietPlan(dietPlan);
		String successMessage = environment.getProperty("API.USER_INSERT_SUCCESS") + dp.getId();
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }

    /************************************************************************************
     * Method: removeDietPlan
     * Description: It is used to delete dietPlan from dietPlan_table
     * @PostMapping: It is used to handle the HTTP DELETE requests matched.
     * @PathVariable: It used to bind the HTTP request body with a parameter.
     *
     ************************************************************************************/
    @DeleteMapping(path ="/delete/{dietPlanId}")
    public ResponseEntity<String> removeDietPlan(@PathVariable int dietPlanId)throws DietPlanNotFoundException{
    	dietService.removeDietPlan(dietPlanId);
		String successMessage = environment.getProperty("API.USER_DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    /************************************************************************************
     * Method: changeDietPlan
     * Description: It is used to update dietPlan of diet_table
     * @PutMapping: It is used to handle the HTTP PUT requests matched.
     * @PathVariable: It used to bind the HTTP request body with a parameter.
     * @RequestParam: It is used take arguments of a function as a request parameters.
     ************************************************************************************/
    @PutMapping(path ="/change/{dietPlanId}")  
    public ResponseEntity<String> changeDietPlan(
            @PathVariable(" dietPlanId") long  dietPlanId,@RequestBody DietPlanDTO dietPlanDTO)throws DietPlanNotFoundException{
    	dietService.changeDietPlan(dietPlanDTO);
    	String successMessage = environment.getProperty("API.USER_UPDATE_SUCCESS");
    	return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }

}
