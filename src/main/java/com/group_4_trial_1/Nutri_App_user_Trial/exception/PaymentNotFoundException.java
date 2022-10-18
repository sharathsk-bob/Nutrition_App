package com.sprint_1.payment_module.exception;

public class PaymentNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PaymentNotFoundException(String msg){
		super(msg);
	}

}
