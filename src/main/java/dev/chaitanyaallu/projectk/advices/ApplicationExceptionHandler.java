package dev.chaitanyaallu.projectk.advices;

import dev.chaitanyaallu.projectk.exceptions.AlienAlreadyExistsException;
import dev.chaitanyaallu.projectk.exceptions.AlienNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(AlienNotFoundException.class)
    public String handleAlienNotFoundException(AlienNotFoundException alienNotFoundException){
        return alienNotFoundException.getMessage();
    }
    @ExceptionHandler(AlienAlreadyExistsException.class)
    public String handleAlienAlreadyExistsException(AlienAlreadyExistsException alienAlreadyExistsException){
        return alienAlreadyExistsException.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String, String> errorMap = new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }
}
