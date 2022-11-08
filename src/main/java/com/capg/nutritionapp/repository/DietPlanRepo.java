package com.capg.nutritionapp.repository;

import com.capg.nutritionapp.entity.DietPlan;
import com.capg.nutritionapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DietPlanRepo extends JpaRepository<DietPlan, Long> {
    Optional<DietPlan> findDietPlanById(long id);

    //@Query("SELECT u FROM User u WHERE u.userId = ?1")
   // Optional<User> findByUserId(String userId);
}
