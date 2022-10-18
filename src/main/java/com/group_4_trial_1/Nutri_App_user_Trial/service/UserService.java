package com.group_4_trial_1.Nutri_App_user_Trial.service;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.User;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    //    public List<Userdto> getByUserId(Userdto user) {
    //        return userRepository.findAll();
    //    }
    User getUserByUserId(String userId);

    User registerUser(User user);

    void deleteUser(Long id);

    @Transactional
    void updateUser(Long id, String name, String contact, String email, String gender, String status, Float weight,
                    Float height, String goal, Time wakeUpTime, Time sleepTime);
}
