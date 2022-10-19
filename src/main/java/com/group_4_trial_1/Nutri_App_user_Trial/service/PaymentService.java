package com.group_4_trial_1.Nutri_App_user_Trial.service;

import java.util.List;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.Payment;
import com.group_4_trial_1.Nutri_App_user_Trial.exception.PaymentNotFoundException;
import org.springframework.stereotype.Service;


@Service
public interface PaymentService {


	
	public void pay(Payment paymentEntity) throws PaymentNotFoundException;
	
	public void addOffer(Payment paymentEntity,float discount) throws PaymentNotFoundException;
	
	public List<Payment> showAllPayments() throws PaymentNotFoundException;
	
	public Payment updatePayment(Payment paymentEntity) throws PaymentNotFoundException;

}
