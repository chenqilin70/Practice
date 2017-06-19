package com.huwl.oracle.springmvc.crud.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by aierxuan on 2017/6/18.
 */
//@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "username is not right")
public class MyException extends RuntimeException{
    public MyException() {
        System.out.println("MyException is exist……");
    }
}
