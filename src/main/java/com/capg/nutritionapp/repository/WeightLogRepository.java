package com.capg.nutritionapp.repository;
import com.capg.nutritionapp.entity.WeightLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Author : Ashish
 * Version : 1.0
 * Date : 19-10-2022
 * Description : This is WeightLogRepository.
*/

@Repository
/*Repository annotation is used to indicate that the class provides the mechanism 
 * for storage, retrieval, search, update and delete operation on objects*/
public interface WeightLogRepository
	        extends JpaRepository<WeightLog,Long> {

	}


