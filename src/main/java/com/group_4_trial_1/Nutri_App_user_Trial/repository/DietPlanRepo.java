package com.group_4_trial_1.Nutri_App_user_Trial.repository;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.DietPlan;
import com.group_4_trial_1.Nutri_App_user_Trial.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DietPlanRepo extends JpaRepository<DietPlan, Integer> {
    Optional<DietPlan> findDietPlanById(int id);

    @Query("SELECT u FROM User u WHERE u.userId = ?1")
    Optional<User> findByUserId(String userId);
}
