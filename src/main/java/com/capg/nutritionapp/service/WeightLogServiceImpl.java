package com.capg.nutritionapp.service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.nutritionapp.entity.WeightLog;
import com.capg.nutritionapp.exception.WeightLogNotFoundException;
import com.capg.nutritionapp.repository.WeightLogRepository;

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
    public String removeWeightLog(Long ID) throws WeightLogNotFoundException {
        // TODO Auto-generated method stub

    	logger.info("removeWeightLog method initiated");

        boolean exists = weightLogRepository.existsById(ID);
        if(!exists){
        	throw new WeightLogNotFoundException("The id mentioned" + ID + "doesn't exists");
        }
        weightLogRepository.deleteById(ID);
        boolean exist = weightLogRepository.existsById(ID);
        if(exist) {
        	throw new WeightLogNotFoundException("The id mentioned" + ID + "does exists");
	
        }
        else {
        	return "removed";
        }
        //logger.info("removeWeightLog method executed");
    }
      
 
  //Description : This method Adds new weightLog : Input Parameter

   @Override
    public WeightLog addWeightLog(WeightLog weightLog)throws WeightLogNotFoundException {
        // TODO Auto-generated method stub
	   logger.info("addWeightLog method executed");
	   WeightLog wl=weightLogRepository.save(weightLog);
	   return wl;     
    }

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


   @Override
   public WeightLog updateWeightLog(WeightLog weightLog, Long ID) throws WeightLogNotFoundException {
        // TODO Auto-generated method stub
	   logger.info("updateWeightLog method initiated");
       WeightLog value=weightLogRepository.findById(ID).orElseThrow(()->new WeightLogNotFoundException("WeightLog with id"+ ID + "does not exist."));
       value.setID(weightLog.getID());
       value.setWeight(weightLog.getWeight());
       value.setCreated_At(weightLog.getCreated_At());
       value.setCreated_At(weightLog.getUpdated_At());
       value.setUserId(weightLog.getUserId());
       logger.info("updateWeightLog method executed");
       return weightLogRepository.save(value);
   }

}