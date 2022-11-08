package com.capg.nutritionapp.controller;

import com.capg.nutritionapp.dto.UserDTO;
import com.capg.nutritionapp.entity.User;
import com.capg.nutritionapp.exception.InvalidDataException;
import com.capg.nutritionapp.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

import javax.validation.Valid;

//Description : This is UserController

@RestController
@RequestMapping(path = "/capg/userinterface")
/*Spring RestController takes care of mapping request data
 * to the defined request handler method
 */
@Validated
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

    @Autowired
        private UserService iuserService;

    @Autowired
	private Environment environment;
    /************************************************************************************
     * Method: getAllUsers
     * Description: It is used to get all users from user_table
     * @GetMapping: It is used to handle the HTTP GET requests matched.
     *
     ************************************************************************************/
    @GetMapping(value="/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() throws InvalidDataException{
    	List<UserDTO> userList = iuserService.getAllUsers();
		return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    /************************************************************************************
     * Method: getByUserId
     * Description: It is used to get user from user_table by its ID
     * @GetMapping: It is used to handle the HTTP GET requests matched.
     *
     ************************************************************************************/
    @GetMapping(path = "/users/{id}")
    public ResponseEntity<UserDTO> getUserByUserId(@PathVariable("userId") Long id) throws InvalidDataException  {
    	UserDTO user = iuserService.getUserByUserId(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
    }


    /************************************************************************************
     * Method: saveUser
     * Description: It is used to add user into user_table
     * @PostMapping: It is used to handle the HTTP POST requests matched.
     * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
     *
     ************************************************************************************/
    @PostMapping(value="/users")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) throws InvalidDataException {
    	User us =iuserService.registerUser(user);
		String successMessage = environment.getProperty("API.USER_INSERT_SUCCESS") + us.getId();
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }


    /************************************************************************************
     * Method: deleteUser
     * Description: It is used to delete user from user_table
     * @PostMapping: It is used to handle the HTTP DELETE requests matched.
     * @PathVariable: It used to bind the HTTP request body with a parameter.
     *
     ************************************************************************************/
    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) throws InvalidDataException {
    	iuserService.deleteUser(id);
		String successMessage = environment.getProperty("API.USER_DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    /************************************************************************************
     * Method: updateUser
     * Description: It is used to update user of user_table
     * @PostMapping: It is used to handle the HTTP PUT requests matched.
     * @PathVariable: It used to bind the HTTP request body with a parameter.
     * @RequestParam: It is used take arguments of a function as a request parameters.
     *
     ************************************************************************************/

    @PutMapping(path = "/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id , @RequestBody UserDTO user) throws InvalidDataException{
    	iuserService.updateUser(user);
    	String successMessage = environment.getProperty("API.USER_UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
    }

}
