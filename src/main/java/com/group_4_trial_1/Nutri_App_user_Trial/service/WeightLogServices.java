package com.example.demo.service;
import com.example.demo.entity.WeightLog;
import com.example.demo.exception.WeightLogNotFoundException;
import java.util.List;
public interface WeightLogServices {

    public WeightLog addWeightLog(WeightLog weightLog)throws WeightLogNotFoundException;

    public WeightLog updateWeightLog(WeightLog weightLog,Long ID) throws WeightLogNotFoundException;

    public void removeWeightLog(Long ID) throws WeightLogNotFoundException;

    public List<WeightLog> showAllWeightLog() throws WeightLogNotFoundException;

	

}