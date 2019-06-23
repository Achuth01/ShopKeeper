package com.product.org.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomException extends Exception {


    CustomException(String message){
        super(message);
    }


}
