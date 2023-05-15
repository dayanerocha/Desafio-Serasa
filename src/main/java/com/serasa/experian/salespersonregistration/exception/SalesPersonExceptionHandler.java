package com.serasa.experian.salespersonregistration.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.serasa.experian.salespersonregistration.controller.response.ErrorMessage;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class SalesPersonExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    protected ResponseEntity<Object> handleSalesPersonMethodArgumentNotValid(
            MethodArgumentNotValidException ex, WebRequest request) {
        ErrorMessage apiError = new ErrorMessage();
        apiError.setMessage("Make sure to provide all the required data.");
        return buildResponseEntity(apiError, BAD_REQUEST);
    }

    private ResponseEntity<Object> buildResponseEntity(ErrorMessage apiError, HttpStatus status) {
        apiError.setStatus(status);
        return new ResponseEntity<>(apiError, status);
    }
}
