package com.capg.nutritionapp.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.nutritionapp.dto.PaymentDTO;
import com.capg.nutritionapp.exception.PaymentNotFoundException;
import com.capg.nutritionapp.service.PaymentServiceImpl;

//import org.springframework.core.env.Environment;
//import java.util.logging.Logger;
//import org.hibernate.resource.beans.internal.BeansMessageLogger_.logger;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//import com.sprint_1.payment_module.dto.PaymentDTO;

@RestController
@RequestMapping(path= "/Payment")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {
	
	//private static final Logger logger = LogManager.getLogger(PaymentController.class); 
	@Autowired
	private PaymentServiceImpl paymentService;

	@Autowired
	private Environment environment;
	
	/**
	 * Update payment.
	 *
	 * @param paymentId the payment id
	 * @param paymentDTO the payment DTO
	 * @return the response entity
	 * @throws PaymentException the payment exception
	 */
	@PutMapping(value = "/updatepayment")
	    public ResponseEntity<PaymentDTO> updatePayment(@RequestBody long id, PaymentDTO paymentDTO)
	            throws PaymentNotFoundException {
		PaymentDTO savedPayment = paymentService.updatePayment(id, paymentDTO);
		return new ResponseEntity<PaymentDTO>(savedPayment, HttpStatus.OK);
	    }
	
	 /**
	 * Gets the all payment details.
	 *
	 * @return the all payment details
	 */
	 @GetMapping(value = "/showallpayments")
	    public ResponseEntity<List<PaymentDTO>> showAllPayments() throws PaymentNotFoundException {
		 List<PaymentDTO> paymentList = paymentService.showAllPayments();
			return new ResponseEntity<List<PaymentDTO>>(paymentList, HttpStatus.OK);
	    }
	 
	 
	 @PutMapping(value = "/addoffertopayment")
	    public ResponseEntity<String> addOffer(@RequestBody PaymentDTO paymentDTO, @PathVariable float discount) throws PaymentNotFoundException {
         paymentService.addOffer(paymentDTO,paymentDTO.getDiscount());
        String successMessage = environment.getProperty("API.INSERT_SUCCESS") + paymentDTO.getId();
	       return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	    }
	 
	 
	  /**
	  * Adds the payment.
	  *
	  * @param paymentDTO the payment DTO
 	  * @return the response entity
	  */
	 @PostMapping(value = "/paythepayment")
		public ResponseEntity<PaymentDTO>  pay(@RequestBody @Valid PaymentDTO paymentDTO)
				throws PaymentNotFoundException {
		 PaymentDTO savedPayment = paymentService.pay(paymentDTO);
			return new ResponseEntity<PaymentDTO>(savedPayment, HttpStatus.CREATED);
	 }
   
}
