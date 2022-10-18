package com.group_4_trial_1.Nutri_App_user_Trial.repository;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

//import java.util.Optional;

/*
 * Author : Tanya
 * Version : 1.0
 * Date : 19-10-2022
 * Description : This is paymentRepository.
*/

/*Repository annotation is used to indicate that the class provides the mechanism 
 * for storage, retrieval, search, update and delete operation on objects*/


public interface PaymentRepository extends JpaRepository<Payment, Long> {
    //@Query("SELECT p FROM Payment p WHERE p.userId = ?1")
    //Optional<PaymentDTO> findPaymentByUserId(String userId);
}
