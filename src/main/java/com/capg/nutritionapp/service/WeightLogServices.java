package com.capg.nutritionapp.service;

import java.util.List;
import com.capg.nutritionapp.dto.WeightLogDTO;
import com.capg.nutritionapp.entity.WeightLog;
import com.capg.nutritionapp.exception.WeightLogNotFoundException;

public interface WeightLogServices {

    public WeightLogDTO addWeightLog(WeightLogDTO weightLogDTO)throws WeightLogNotFoundException;
    
    public WeightLogDTO updateWeightLog(WeightLogDTO weightLogDTO, Long ID) throws WeightLogNotFoundException;

    public WeightLogDTO removeWeightLog(Long ID) throws WeightLogNotFoundException, WeightLogNotFoundException;

    public List<WeightLog> showAllWeightLog() ;

	

}