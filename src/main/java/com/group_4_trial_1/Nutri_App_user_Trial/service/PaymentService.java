package com.sprint_1.payment_module.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.sprint_1.payment_module.entity.Payment;
import com.sprint_1.payment_module.exception.PaymentNotFoundException;

@Service
public interface PaymentService {


	
	public void pay(Payment paymentEntity) throws PaymentNotFoundException;
	
	public void addOffer(Payment paymentEntity,float discount) throws PaymentNotFoundException;
	
	public List<Payment> showAllPayments() throws PaymentNotFoundException;
	
	public Payment updatePayment(Payment paymentEntity) throws PaymentNotFoundException;

}
