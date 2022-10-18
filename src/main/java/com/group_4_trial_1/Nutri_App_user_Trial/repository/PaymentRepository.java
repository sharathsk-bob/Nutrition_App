package com.sprint_1.payment_module.repository;

import com.sprint_1.payment_module.dto.PaymentDTO;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

//import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentDTO, Long> {
    //@Query("SELECT p FROM Payment p WHERE p.userId = ?1")
    //Optional<PaymentDTO> findPaymentByUserId(String userId);
}
