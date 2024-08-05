package com.Magistances.chatbot.Coontroller.AviceController;

import com.Magistances.chatbot.Coontroller.AviceController.Exepcions.isAlreadyExist;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity validdatefilters(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(isAlreadyExist.class)
    public ResponseEntity isAlreadyExist(isAlreadyExist ex){
        var errosrs =  new isAlreadyExist("The User already exist");
        return ResponseEntity.badRequest().body(errosrs);
    }

}
