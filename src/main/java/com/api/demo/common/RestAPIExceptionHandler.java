package com.api.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.webjars.NotFoundException;

@Slf4j
@RestControllerAdvice
public class RestAPIExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {NoHandlerFoundException.class, NotFoundException.class})
    public CommRespDto handleNotFound() {
        return CommRespDto.notFound();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {BadRequestException.class})
    public CommRespDto handleBadRequestException(Exception e) {
        return CommRespDto.badRequest(e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public CommRespDto handleException(Exception e) {
        log.error(" INTERNAL SERVER ERROR : {}", e.getMessage());
        return CommRespDto.error("INTERNAL SERVER ERROR");
    }
}
