package com.Magistances.chatbot.Coontroller.AviceController.Exepcions;

import org.springframework.http.HttpStatus;

public class isAlreadyExist extends RuntimeException{
    private String message;
    private HttpStatus status;

    public isAlreadyExist(String message) {
        super(message);

    }
}
