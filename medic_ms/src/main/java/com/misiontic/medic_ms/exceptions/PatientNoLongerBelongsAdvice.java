package com.misiontic.medic_ms.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class PatientNoLongerBelongsAdvice {
    @ResponseBody
    @ExceptionHandler(PatientNoLongerBelongsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String EntityNotFoundAdvide(PatientNoLongerBelongsException ex){
        return ex.getMessage();
    }
}