package com.amex.sms.school;

import com.amex.sms.school.exceptions.BadRequestException;
import com.amex.sms.school.exceptions.NotFoundException;
import com.amex.sms.school.exceptions.RecordAlreadyExistException;
import com.amex.sms.school.model.AppError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mayukha
 * Created on 27 Oct, 2023
 * @project school
 */

@ControllerAdvice
public class SchoolControllerAdvice {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<AppError> handleNotFoundException(NotFoundException ex, WebRequest request){
        AppError message = new AppError(HttpStatus.NOT_FOUND.toString(), Arrays.asList(ex.getMessage()));
        return new ResponseEntity<AppError>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<AppError> handleBadRequestException(BadRequestException ex, WebRequest request){
        AppError message = new AppError(HttpStatus.BAD_REQUEST.toString(), Arrays.asList(ex.getMessage()));
        return new ResponseEntity<AppError>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {RecordAlreadyExistException.class})
    public ResponseEntity<AppError> handleRecordAlreadyExistException(RecordAlreadyExistException ex, WebRequest request){
        AppError message = new AppError(HttpStatus.CONFLICT.toString(), Arrays.asList(ex.getMessage()));
        return new ResponseEntity<AppError>(message, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppError> notValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();

        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));
        AppError error = new AppError(HttpStatus.BAD_REQUEST.toString(), errors);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<AppError> globalExceptionHandler(Exception ex, WebRequest request) {
        AppError message = new AppError(HttpStatus.INTERNAL_SERVER_ERROR.toString(), Arrays.asList(ex.getMessage()));

        return new ResponseEntity<AppError>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}