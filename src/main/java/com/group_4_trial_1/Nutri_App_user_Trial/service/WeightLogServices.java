package com.group_4_trial_1.Nutri_App_user_Trial.service;

import com.group_4_trial_1.Nutri_App_user_Trial.entity.WeightLog;
import com.group_4_trial_1.Nutri_App_user_Trial.exception.WeightLogNotFoundException;

import java.util.List;

import javax.transaction.Transactional;
public interface WeightLogServices {

    public WeightLog addWeightLog(WeightLog weightLog)throws WeightLogNotFoundException;
@Transactional
    public WeightLog updateWeightLog(WeightLog weightLog, Long ID) throws WeightLogNotFoundException;

    public void removeWeightLog(Long ID) throws WeightLogNotFoundException, WeightLogNotFoundException;

    public List<WeightLog> showAllWeightLog() throws WeightLogNotFoundException;

	

}