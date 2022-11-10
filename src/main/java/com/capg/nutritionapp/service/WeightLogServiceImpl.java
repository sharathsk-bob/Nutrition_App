package com.capg.nutritionapp.service;

import com.capg.nutritionapp.dto.WeightLogDTO;
import com.capg.nutritionapp.entity.User;
import com.capg.nutritionapp.entity.WeightLog;
import com.capg.nutritionapp.exception.InvalidDataException;
import com.capg.nutritionapp.exception.WeightLogNotFoundException;
import com.capg.nutritionapp.repository.WeightLogRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//Description : This is weightLog Service Layer

@Service
public class  WeightLogServiceImpl  implements WeightLogServices {
	private static final Logger logger = LogManager.getLogger(WeightLogServiceImpl.class);
    
    private WeightLogRepository weightLogRepository = null;
    @Autowired
    public void weightLogService(WeightLogRepository weightLogRepository) {
        this.weightLogRepository= weightLogRepository;
    }

/*
 * Description : This method removes existing ID :Input Parameter 
 *               Throws Exception if the ID is not found as WeightLogNotFoundException
 */	
    
    @Override
    public WeightLogDTO removeWeightLog(Long ID) throws WeightLogNotFoundException {
        // TODO Auto-generated method stub
    	logger.info("removeWeightLog method initiated");
        boolean exists = weightLogRepository.existsById(ID);
       if(!exists){
    	throw new WeightLogNotFoundException("The id mentioned" + ID + "doesn't exists");
       }
       weightLogRepository.deleteById(ID);
       logger.info("removeWeightLog method executed");
	return null;
    }

	@Override
	public WeightLogDTO addWeightLog(WeightLogDTO weightLogDTO) throws WeightLogNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WeightLogDTO updateWeightLog(WeightLogDTO weightLogDTO, Long ID) throws WeightLogNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


 
  //Description : This method Adds new weightLog : Input Parameter

//   @Override
//    public WeightLogDTO addWeightLog(WeightLogDTO weightLogDTO)throws WeightLogNotFoundException {
//        // TODO Auto-generated method stub
//	   logger.info("addWeightLog method executed");
//	   WeightLog wl=weightLogRepository.save(weightLog);
//	   return wl;    
//    }

/*
 * Description : This method shows existing weightLog :Input Parameter 
 *          
 */

   @Override
    public List<WeightLog> showAllWeightLog() {
        // TODO Auto-generated method stub
	   logger.info("showAllWeightLog method initiated");
        return weightLogRepository.findAll().stream().toList();
    }

     /*
	 * Description : This method Updates existing weightLog by taking ID:Input Parameter 
	 *               Throws Exception if the ID is not found as WeightLogNotFoundException	
	 */

//   @Override
//   public WeightLogDTO updateWeightLog(WeightLogDTO weightLogDTO, Long ID) throws WeightLogNotFoundException {
//        // TODO Auto-generated method stub
//	  Optional<WeightLogDTO> user1 = weightLogRepository.findById(weightLogDTO.getId());
//	  WeightLog c = WeightLogDTO.orElseThrow(() -> new InvalidDataException("Service.USER_NOT_FOUND"));
//		
//      WeightLog value = weightLogRepository.findById(ID).orElseThrow(()->new WeightLogNotFoundException("WeightLog with id"+ ID + "does not exist."));
//      
//      value.setWeight(weightLogDTO.getWeight());
//      value.setCreated_At(weightLogDTO.getCreated_At());
//      value.setCreated_At(weightLogDTO.getUpdated_At());
//      value.setUserId(weightLogDTO.getUserId());
//      return value;
//    }


}






