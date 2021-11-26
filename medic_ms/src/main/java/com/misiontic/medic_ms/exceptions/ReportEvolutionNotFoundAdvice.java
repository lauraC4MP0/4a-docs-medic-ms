package com.misiontic.medic_ms.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
@ResponseBody

public class ReportEvolutionNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ReportEvolutionNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String ReportEvolutionNotFoundAdvice (ReportEvolutionNotFoundException ex){
        return ex.getMessage();
    }
}
