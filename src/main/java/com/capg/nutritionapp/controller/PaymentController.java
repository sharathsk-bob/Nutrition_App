package com.capg.nutritionapp.controller;

import java.util.List;
import com.capg.nutritionapp.entity.Payment;
import com.capg.nutritionapp.exception.PaymentNotFoundException;
import com.capg.nutritionapp.service.PaymentServiceImpl;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.nutritionapp.dto.PaymentDTO;

//import org.springframework.core.env.Environment;
//import java.util.logging.Logger;
//import org.hibernate.resource.beans.internal.BeansMessageLogger_.logger;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//import com.sprint_1.payment_module.dto.PaymentDTO;

@RestController
@RequestMapping(path= "/Payment")
public class PaymentController {
	
	//private static final Logger logger = LogManager.getLogger(PaymentController.class); 
	@Autowired
	private PaymentServiceImpl paymentService;

	@Autowired
	private Environment environment;
	
	@PutMapping(value = "/updatepayment")
	    public ResponseEntity<String> updatePayment(@RequestBody long id, PaymentDTO paymentDTO)
	            throws PaymentNotFoundException {
	        paymentService.updatePayment(id, paymentDTO);
	        String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
	        return new ResponseEntity<>(successMessage, HttpStatus.OK);
	    }
	
	
	 @GetMapping(value = "/showallpayments")
	    public ResponseEntity<List<Payment>> showAllPayments() throws PaymentNotFoundException {
	        List<Payment> paymentList = paymentService.showAllPayments();
	        return new ResponseEntity<>(paymentList, HttpStatus.OK);
	    }
	 
	 
	 @PutMapping(value = "/addoffertopayment")
	    public ResponseEntity<String> addOffer(@RequestBody PaymentDTO paymentDTO, @PathVariable float discount) throws PaymentNotFoundException {
         paymentService.addOffer(paymentDTO,paymentDTO.getDiscount());
        String successMessage = environment.getProperty("API.INSERT_SUCCESS") + paymentDTO.getId();
	       return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	    }
	 
		
	 @PostMapping(value = "/paythepayment")
		public ResponseEntity<String> pay(@RequestBody PaymentDTO paymentDTO)
				throws PaymentNotFoundException {
			paymentService.pay(paymentDTO);
			String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);	
	 }
   
}
