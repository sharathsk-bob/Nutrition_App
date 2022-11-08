package com.capg.nutritionapp.service;

import java.util.List;

import com.capg.nutritionapp.dto.PaymentDTO;
import com.capg.nutritionapp.entity.Payment;
import com.capg.nutritionapp.exception.PaymentNotFoundException;

/**
 * The Interface IPaymentService.
 */

public interface IPaymentService {
	
	/**
	 * Adds the payment.
	 * @param payment the payment
	 * @return the payment DTO
	 */
	PaymentDTO pay(PaymentDTO paymentDTO);
	
	/**
	 * Adds offers to payment details.
	 *
	 * @return the all payment details
	 */
	PaymentDTO addOffer(PaymentDTO paymentDTO,float discount) throws PaymentNotFoundException;
	
	/**
	 * Gets the all payment details.
	 *
	 * @return the all payment details
	 */
	List<Payment> showAllPayments() throws PaymentNotFoundException;
	
	/**
	 * Update payment.
	 *
	 * @param id the id ??
	 * @param payment the payment
	 * @return the payment DTO
	 * @throws PaymentException the payment exception
	 */
	PaymentDTO updatePayment(long id, PaymentDTO paymentDTO) throws PaymentNotFoundException;

}