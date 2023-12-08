package com.amex.sms.school.exceptions;

/**
 * @author Mayukha
 * Created on 27 Oct, 2023
 * @project school
 */
public class RecordAlreadyExistException extends RuntimeException{

    public RecordAlreadyExistException(String message){
        super(message);
    }
    public RecordAlreadyExistException(){
        super("Record Already Exist");
    }

}
