package com.capg.nutritionapp.repository;

import com.capg.nutritionapp.entity.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * Author : Pratik
 * Version : 1.0
 * Date : 19-10-2022
 * Description : This is UserRepository.
 */

@Repository
/*Repository annotation is used to indicate that the class provides the mechanism
 * for storage, retrieval, search, update and delete operation on objects*/
public interface UserRepository extends CrudRepository<User, Long> {

    // Postgres query -> SELECT user from user_table WHERE user_identification = ?;
    //@Query("SELECT u FROM User u WHERE u.userId = ?1")
    //Optional<User> findByUserId(String userId);

//    @Query("DELETE from Userdto u WHERE u.userId = ?1")
//    void deleteByuserId(String userId);

    //@Query("SELECT u FROM User u WHERE u.email = ?1")
    List<User> findUserByemail(String email);
}
