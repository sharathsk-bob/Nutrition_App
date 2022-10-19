package com.group_4_trial_1.Nutri_App_user_Trial.service;


import com.group_4_trial_1.Nutri_App_user_Trial.entity.Payment;
import com.group_4_trial_1.Nutri_App_user_Trial.exception.PaymentNotFoundException;
import com.sprint_1.payment_module.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//import java.util.Optional;

@Component
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	//private static final Logger logger = LogManager.getLogger(PaymentServiceImpl.class); 
	@Autowired
	private PaymentRepository paymentRepository;
//	@Autowired
//	private ModelMapper mapper;

   /* @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, ModelMapper mapper) {
        this.paymentRepository = paymentRepository;
        this.mapper=mapper;
    }*/



   /* public Optional<PaymentDTO> getPaymentByUserId(String userId) {
        boolean exist = paymentRepository.findPaymentByUserId(userId).isPresent();
        if(!exist) {
            throw new IllegalStateException("Payment not found...");
        }
        return paymentRepository.findPaymentByUserId(userId);
    }*/
    
    @Override
	public void pay(Payment paymentEntity) throws PaymentNotFoundException {
    	
    	paymentRepository.save(paymentEntity);
    	
    	//logger.info("pay method initiated");
//		Payment value = paymentRepository.findById(paymentEntity.getId()).
//                orElseThrow(()->new PaymentNotFoundException("Payment with id "+
//                		paymentEntity.getId() +" does not exist."));
//		if(value.getPayment()!=0) {
//			throw new PaymentNotFoundException("Payment already done");
//		}
//		else {
//			value.setPayment(payment);
//			value.setUpdated_At(LocalDate.now());
//		}
//		
		//mapToEntity(paymentEntity);
		//logger.info("pay method executed");
	}

	@Override
	public void addOffer(Payment paymentEntity, float discount) throws PaymentNotFoundException {
		
		//logger.info("addOffer method initiated");
		Payment value = paymentRepository.findById(paymentEntity.getId()).
                orElseThrow(()->new PaymentNotFoundException("Payment with id "+
                		paymentEntity.getId() +" does not exist."));
		if(value.getDiscount()!= 0f) {
			throw new PaymentNotFoundException("Discount already exist");
			
		}
		else {
			value.setDiscount(discount);
		}
		
		//mapToEntity(paymentDto);
		//logger.info("addOffer method executed"); 
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
	public Payment updatePayment(Payment paymentEntity) throws PaymentNotFoundException {
		
		//logger.info("update method initiated");
		Payment value = paymentRepository.findById(paymentEntity.getId()).
                orElseThrow(()->new PaymentNotFoundException("Payment with id "+
                		paymentEntity.getId() +" does not exist."));
        value.setId(paymentEntity.getId());
        value.setPayment(paymentEntity.getPayment());
        value.setDiscount(paymentEntity.getDiscount());
        value.setCreated_At(paymentEntity.getCreated_At());
        value.setUpdated_At(paymentEntity.getUpdated_At());
        value.setUserId(paymentEntity.getUserId());
        value.setPlanId(paymentEntity.getPlanId());
        
        //mapToEntity(paymentEntity);
        
       // logger.info("update method executed");
        return value;
	}
	
	/*private Payment mapToEntity(PaymentDTO paymentDto) {
		
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Payment payment= mapper.map(paymentDto, Payment.class);
		return payment;
		
	}*/
	
	


}
