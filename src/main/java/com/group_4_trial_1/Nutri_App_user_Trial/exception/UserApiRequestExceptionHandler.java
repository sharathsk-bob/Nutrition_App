package com.group_4_trial_1.Nutri_App_user_Trial.exception;

//import com.group_4_trial_1.Nutri_App_user_Trial.utility.ErrorInfo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class UserApiRequestExceptionHandler {

    @ExceptionHandler(value = {UserApiRequestException.class})
    public ResponseEntity<Object> handleUserApiRequestException(UserApiRequestException ue) {
        // Creating payload to send into the response entity containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        UserApiException userApiException = new UserApiException(
                ue.getMessage(),
//                ue,
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        //Return response entity
        return new ResponseEntity<>(userApiException, badRequest);

    }

//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity<ErrorInfo> handleException(Exception e) {
//        // Creating payload to send into the response entity containing exception details
//        ErrorInfo errInfo = new ErrorInfo();
//        errInfo.setErrorMessage("Some exception occured! Please check Logs");
//        errInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        errInfo.setTimeStamp(LocalDateTime.now());
//        return new ResponseEntity<ErrorInfo>(errInfo, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
