package com.group_4_trial_1.Nutri_App_user_Trial.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static Logger logger = LogManager.getLogger();

    @AfterThrowing(pointcut = "execution(* com.group_4_trial_1.Nutrition_Application.service.*.*(..))", throwing = "exception")
    public void logServiceException(Exception exception) {
        logger.error(exception.getMessage(), exception);
    }
}
