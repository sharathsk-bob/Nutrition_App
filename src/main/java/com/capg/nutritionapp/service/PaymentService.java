package com.capg.nutritionapp.service;

import java.util.List;

import com.capg.nutritionapp.entity.Payment;
import com.capg.nutritionapp.exception.PaymentNotFoundException;
import org.springframework.stereotype.Service;


@Service
public interface PaymentService {


	
	public void pay(Payment paymentEntity) throws PaymentNotFoundException;
	
	public void addOffer(Payment paymentEntity,float discount) throws PaymentNotFoundException;
	
	public List<Payment> showAllPayments() throws PaymentNotFoundException;
	
	public Payment updatePayment(Payment paymentEntity) throws PaymentNotFoundException;

}
