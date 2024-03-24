package com.sast.sast_woc.exceptionhandler;

import com.sast.sast_woc.pojo.response.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Response ex(Exception ex){
        return Response.error();
    }
}
