package guru.springframework.msscbrewery.web.controller;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//advice spring MVC that this is a exception handler.
public class MvcExceptionHandler {
    @ExceptionHandler({ConstraintViolationException.class})
    //will be added to all controllers
    //valid fail will throw a constranitviolationexception,this handle will capture the exception
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException e){
        List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
        //initialize the arraylist to the size of the constraint violation
        //multiple violations so provide back a list of them to the client, so the client know how to fix

        e.getConstraintViolations().forEach(constraintViolation -> {
            errors.add(constraintViolation.getPropertyPath() + ":" + constraintViolation.getMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    //how to handle a bind exception
    public ResponseEntity<List> handleBindException(BindException ex){

        return new ResponseEntity(ex.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
}
