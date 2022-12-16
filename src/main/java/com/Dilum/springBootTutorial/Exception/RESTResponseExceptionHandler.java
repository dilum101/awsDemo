package com.Dilum.springBootTutorial.Exception;

import com.Dilum.springBootTutorial.Entity.ErrorMessege;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RESTResponseExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessege> departmentNotFoundException(DepartmentNotFoundException exception, WebRequest request)
    {
        ErrorMessege message = new ErrorMessege(HttpStatus.NOT_FOUND,exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

}
