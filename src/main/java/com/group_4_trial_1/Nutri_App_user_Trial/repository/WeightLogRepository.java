package com.group_4_trial_1.Nutri_App_user_Trial.repository;
import com.group_4_trial_1.Nutri_App_user_Trial.entity.WeightLog;
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


