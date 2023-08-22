package com.example.hotels_api.Api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApiExeption extends RuntimeException{
    public ApiExeption(String message){
        super(message);
    }

}
