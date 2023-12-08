package com.amex.sms.school.exceptions;

/**
 * @author Mayukha
 * Created on 27 Oct, 2023
 * @project school
 */
public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
    public NotFoundException(){
        super("Record Not Found");
    }

}
