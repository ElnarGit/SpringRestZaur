package org.example.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalException {

    @ExceptionHandler
    private ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException e){
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                "Employee with this id wasn't found!");

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler
    private ResponseEntity<EmployeeErrorResponse> handleException(Exception e){
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                e.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}
