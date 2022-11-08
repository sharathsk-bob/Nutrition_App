package com.capg.nutritionapp.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.nutritionapp.dto.PaymentDTO;
import com.capg.nutritionapp.entity.Payment;
import com.capg.nutritionapp.exception.PaymentNotFoundException;
import com.capg.nutritionapp.repository.PaymentRepository;
//import java.util.Optional;

/**
 * The Class PaymentServiceImpl.
 */
@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {
	
	/** The payment repository. */ 
	@Autowired
	private PaymentRepository paymentRepository;

	
    
    @Override
	public PaymentDTO pay(PaymentDTO paymentDTO){
    	Payment payment = paymentDTO.toPayment();
		Payment savedPayment = paymentRepository.save(payment);
		return savedPayment.toPaymentDTO();
	}

	@Override
	public PaymentDTO addOffer(PaymentDTO paymentDTO, float discount) throws PaymentNotFoundException {
		
		//logger.info("addOffer method initiated");
		Payment Discountedvalue = paymentRepository.findById(paymentDTO.getId()).
                orElseThrow(()->new PaymentNotFoundException("Payment with id "+
                paymentDTO.getId() +" does not exist."));
		if(Discountedvalue.getDiscount()!= 0f) {
			throw new PaymentNotFoundException("Discount already exist");
		}
		else {
			Discountedvalue.setDiscount(discount);
		}		
		//mapToEntity(paymentDto);
		//logger.info("addOffer method executed");
		return Discountedvalue.toPaymentDTO();
	}
	
    @Override
    public List<Payment> showAllPayments() throws PaymentNotFoundException {
    	//logger.info("showAllPayment method initiated"); 
    	//System.out.println("Getting data from DB:" + payment);
    	//logger.info("showAllPayment method executed");
    	List<Payment> iterable= paymentRepository.findAll();
    	return iterable; 
    	}

	@Override
	@Transactional
	public PaymentDTO updatePayment(long id, PaymentDTO paymentDTO) throws PaymentNotFoundException {
		
		//logger.info("update method initiated");
		Optional<Payment> optionalPayment = paymentRepository.findById(id);
		Payment payment = optionalPayment.orElseThrow(()->new PaymentNotFoundException("Payment with this id does not exist."));
		
//		if(paymentDTO.getPayment() != null)
//			payment.setPayment(paymentDTO.getPayment());
//		if(paymentDTO.getDiscount() != null)
//			payment.setDiscount(paymentDTO.getDiscount());
		if(paymentDTO.getCreated_At() != null)
			payment.setDiscount(paymentDTO.getDiscount());
		if(paymentDTO.getUpdated_At() != null)
			payment.setDiscount(paymentDTO.getDiscount());
		return payment.toPaymentDTO();
	}
	

}