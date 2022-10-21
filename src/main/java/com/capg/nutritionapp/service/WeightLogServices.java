package com.capg.nutritionapp.service;

import com.capg.nutritionapp.entity.WeightLog;
import com.capg.nutritionapp.exception.WeightLogNotFoundException;

import java.util.List;

import javax.transaction.Transactional;
public interface WeightLogServices {

    public WeightLog addWeightLog(WeightLog weightLog)throws WeightLogNotFoundException;
@Transactional
    public WeightLog updateWeightLog(WeightLog weightLog, Long ID) throws WeightLogNotFoundException;

    public void removeWeightLog(Long ID) throws WeightLogNotFoundException, WeightLogNotFoundException;

    public List<WeightLog> showAllWeightLog() throws WeightLogNotFoundException;

	

}