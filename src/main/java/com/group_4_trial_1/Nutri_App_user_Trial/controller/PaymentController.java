package com.sprint_1.payment_module.controller;
import java.util.List;


import org.springframework.core.env.Environment;


//import java.util.logging.Logger;


//import org.hibernate.resource.beans.internal.BeansMessageLogger_.logger;
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
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//import com.sprint_1.payment_module.dto.PaymentDTO;
import com.sprint_1.payment_module.entity.Payment;
import com.sprint_1.payment_module.exception.PaymentNotFoundException;
import com.sprint_1.payment_module.service.PaymentService;


/*import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint_1.payment_module.dto.PaymentDTO;
import com.sprint_1.payment_module.exception.PaymentNotFoundException;
import com.sprint_1.payment_module.service.PaymentService;*/



@RestController
@RequestMapping(path= "/Payment")
public class PaymentController {
	
	//private static final Logger logger = LogManager.getLogger(PaymentController.class); 
	@Autowired
	private PaymentService paymentService;
	
//	@Autowired
//	public PaymentController(PaymentService paymentService) {
//		this.paymentService= paymentService;
//	}
//	
	
	/*@PutMapping(path ="id")
	  public void pay(@RequestBody Payment paymentEntity, @PathVariable float price) throws PaymentNotFoundException
	   {
	      try{
	    	 paymentService.pay(paymentEntity,price);}
	  catch(Exception e)
	  {
		  LOGGER.info("The plan you are requesting to update doesn't exists");
	  }
	  }
	
	@PutMapping(path ="id")
	  public void addOffer(@RequestBody Payment paymentEntity, @PathVariable float discount) throws PaymentNotFoundException
	   {
	      try{
	    	 paymentService.addOffer(paymentEntity,discount);}
	  catch(Exception e)
	  {
		  logger.info("The plan you are requesting to update doesn't exists");
	  }
	  }
	
	@PutMapping(path ="id")
	  public void updatePayment(@RequestBody Payment paymentEntity) throws PaymentNotFoundException
	   {
	      try{
	    	 paymentService.updatePayment(paymentEntity);}
	  catch(Exception e)
	  {
		  logger.info("The plan you are requesting to update doesn't exists");
	  }
	  }
	
	   @GetMapping
	    public List<Payment> showAllPayments() throws PaymentNotFoundException{
	       return paymentService.showAllPayments();
	   }*/
	
	@Autowired
	private Environment environment;
	
	@PutMapping(value = "/payment1")
	    public ResponseEntity<String> updatePayment(@RequestBody Payment paymentEntity)
	            throws PaymentNotFoundException {
	         paymentService.updatePayment(paymentEntity);
	        String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
	        return new ResponseEntity<>(successMessage, HttpStatus.OK);
	    }
	
	
	 @GetMapping(value = "/payment")
	    public ResponseEntity<List<Payment>> showAllPayments() throws PaymentNotFoundException {
	        List<Payment> paymentList = paymentService.showAllPayments();
	        return new ResponseEntity<>(paymentList, HttpStatus.OK);
	    }
	 
	 
	 @PutMapping(value = "/payments")
	    public ResponseEntity<String> addOffer(@RequestBody Payment paymentEntity, @PathVariable float discount) throws PaymentNotFoundException {
         paymentService.addOffer(paymentEntity,paymentEntity.getDiscount());
        String successMessage = environment.getProperty("API.INSERT_SUCCESS") + paymentEntity.getId();
	       return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	    }
	 
		
	 @PostMapping(value = "/payment")
		public ResponseEntity<String> pay(@RequestBody Payment paymentEntity)
				throws PaymentNotFoundException {
			paymentService.pay(paymentEntity);
			String successMessage = environment.getProperty("API.UPDATE_SUCCESS");
			return new ResponseEntity<>(successMessage, HttpStatus.OK);	
	 }
   

	
	
	
	

}
