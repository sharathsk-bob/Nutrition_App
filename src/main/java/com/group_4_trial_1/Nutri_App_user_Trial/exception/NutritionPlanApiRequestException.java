package com.group_4_trial_1.Nutri_App_user_Trial.exception;

public class NutritionPlanApiRequestException extends RuntimeException {

    public NutritionPlanApiRequestException(String message) {
        super(message);
    }

    public NutritionPlanApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
