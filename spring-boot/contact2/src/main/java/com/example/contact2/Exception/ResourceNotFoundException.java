package com.example.contact2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException{
    public static final long seriolVersionUID = 1L;

    public ResourceNotFoundException(String message){

    }


}
