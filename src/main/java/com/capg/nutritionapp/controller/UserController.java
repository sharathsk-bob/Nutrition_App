package com.capg.nutritionapp.controller;

import com.capg.nutritionapp.entity.User;
import com.capg.nutritionapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

//Description : This is UserController

@RestController
@RequestMapping(path = "/user")
/*Spring RestController takes care of mapping request data
 * to the defined request handler method
 */
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    /************************************************************************************
     * Method: getAllUsers
     * Description: It is used to get all users from user_table
     * @GetMapping: It is used to handle the HTTP GET requests matched.
     *
     ************************************************************************************/
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    /************************************************************************************
     * Method: getByUserId
     * Description: It is used to get user from user_table by its ID
     * @GetMapping: It is used to handle the HTTP GET requests matched.
     *
     ************************************************************************************/
    @GetMapping(path = "{userId}")
    public User getByUserId(@PathVariable("userId") String userId) {
        return userService.getUserByUserId(userId);
    }


    /************************************************************************************
     * Method: saveUser
     * Description: It is used to add user into user_table
     * @PostMapping: It is used to handle the HTTP POST requests matched.
     * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
     *
     ************************************************************************************/
    @PostMapping
    public void saveUser(@RequestBody User user) {
        userService.registerUser(user);
    }


    /************************************************************************************
     * Method: deleteUser
     * Description: It is used to delete user from user_table
     * @PostMapping: It is used to handle the HTTP DELETE requests matched.
     * @PathVariable: It used to bind the HTTP request body with a parameter.
     *
     ************************************************************************************/
    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }

    /************************************************************************************
     * Method: updateUser
     * Description: It is used to update user of user_table
     * @PostMapping: It is used to handle the HTTP PUT requests matched.
     * @PathVariable: It used to bind the HTTP request body with a parameter.
     * @RequestParam: It is used take arguments of a function as a request parameters.
     *
     ************************************************************************************/

    @PutMapping(path = "{id}")
    public void updateUser(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String contact,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Float weight,
            @RequestParam(required = false) Float height,
            @RequestParam(required = false) String goal,
            @RequestParam(required = false) Time wakeUpTime,
            @RequestParam(required = false) Time sleepTime
            ) {
        userService.updateUser(id, name, contact, email, gender, status, weight, height, goal, wakeUpTime, sleepTime);
    }

}
