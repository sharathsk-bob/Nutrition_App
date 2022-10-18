package com.group_4_trial_1.Nutri_App_user_Trial.service;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.Status;
import com.group_4_trial_1.Nutri_App_user_Trial.entity.User;
import com.group_4_trial_1.Nutri_App_user_Trial.exception.UserApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.group_4_trial_1.Nutri_App_user_Trial.repository.UserRepository;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {
    private UserRepository userRepository;
//    private Logger logger;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
//        logger.info("Getting all users request initiated...");
        return userRepository.findAll();
    }

//    public List<Userdto> getByUserId(Userdto user) {
//        return userRepository.findAll();
//    }
    public User getUserByUserId(String userId) {
//        logger.info("Getting user by its ID");
        boolean exist = userRepository.findByUserId(userId).isPresent();
        if(!exist) {
//            logger.info("Could not retrive user !");
            throw new UserApiRequestException("User with " + userId + " is not present in database right now !");
        }
//        logger.info("Found User :-)");
       return userRepository.findByUserId(userId).get();
    }

    public User registerUser(User user) {
        Optional<User> optionalUser = userRepository
                                        .findByUserId(user.getUserId());
        if(optionalUser.isPresent()) {
            throw new UserApiRequestException("User is already present in the Database !");
//            throw new IllegalStateException("User is already present in the Database !");
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
//        boolean exist = userRepository.existsById(id);
        boolean exist = userRepository.findById(id).isPresent();

        if (!exist) {
            throw new UserApiRequestException("User is not present in the database ! Please try with different User Id !");
//            throw new IllegalStateException("User is not present in the database ! Please try with different User Id !");
        }
        userRepository.deleteById(id);

    }

    @Transactional
    public void updateUser(Long id, String name, String contact, String email, String gender, String status, Float weight,
                           Float height, String goal, Time wakeUpTime, Time sleepTime)
    {
        System.out.println(status);
            User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException(
                    "User with this id is not present in the database."
        ));
            if(name != null && name.length() > 0 && !Objects.equals(name, user.getName())) {
                user.setName(name);
            }

            if(contact != null && contact.length() == 10 && !Objects.equals(contact, user.getContact())) {
                user.setContact(contact);
            }

            if(email != null && email.length() > 0 && email.contains("@") && email.contains(".")
                    && Objects.equals(email, user.getEmail())) {
                Optional<User> optionalUser = userRepository.findUserByemail(email);
                if(optionalUser.isPresent()) {
                    throw new UserApiRequestException("User with same email is already present in the database!");
//                    throw new IllegalStateException("User with same email is already present in the database!");
                }
                user.setEmail(email);
            }

//            if(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || !gender.equals(null)){
//                user.setGender(gender);
//            }
                user.setStatus(status);
//

//            if(weight > 0f) {
//                user.setWeight(weight);
//            }
//            if(height > 0f) {
//                user.setHeight(height);
//            }
//
//            if(goal != null && goal.length() > 0 && !Objects.equals(goal, user.getGoal())) {
//                user.setGoal(goal);
//            }
//
//            if(wakeUpTime != null) {
//                user.setWakeUpTime(wakeUpTime);
//            }
//            if(sleepTime != null) {
//                user.setSleepTime(sleepTime);
//            }
    }
}
