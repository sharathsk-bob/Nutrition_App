package com.group_4_trial_1.Nutri_App_user_Trial.repository;


import com.group_4_trial_1.Nutri_App_user_Trial.entity.Payment;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.data.jpa.repository.Query;


//import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    //@Query("SELECT p FROM Payment p WHERE p.userId = ?1")
    //Optional<PaymentDTO> findPaymentByUserId(String userId);
}
