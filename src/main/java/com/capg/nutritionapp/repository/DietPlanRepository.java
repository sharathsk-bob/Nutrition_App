package com.capg.nutritionapp.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.capg.nutritionapp.dto.DietPlanDTO;
import com.capg.nutritionapp.entity.DietPlan;

@Repository
public interface DietPlanRepository extends CrudRepository<DietPlan, Long> {
    Optional<DietPlan> findDietPlanById(long id);

//    @Query("SELECT u FROM User u WHERE u.userId = ?1")
//    Optional<User> findByUserId(String userId);

	Optional<DietPlan> findDietPlanById(Object setId);

	DietPlanDTO save(DietPlanDTO dietPlanDTO);
    
}
