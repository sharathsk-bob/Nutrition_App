package com.capg.nutritionapp.service;

import java.util.List;
import javax.transaction.Transactional;
import com.capg.nutritionapp.entity.WeightLog;
import com.capg.nutritionapp.exception.WeightLogNotFoundException;

public interface WeightLogServices {

    public WeightLog addWeightLog(WeightLog weightLog)throws WeightLogNotFoundException;
    @Transactional
    public WeightLog updateWeightLog(WeightLog weightLog, Long ID) throws WeightLogNotFoundException;

    public String removeWeightLog(Long ID) throws WeightLogNotFoundException, WeightLogNotFoundException;

    public List<WeightLog> showAllWeightLog() throws WeightLogNotFoundException;

	

}