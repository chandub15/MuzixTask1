package com.stackroute.lombokDemo.exceptions;

public class CRUDException extends  Exception {
    private String message;

    public  CRUDException(String message){
        super(message);
        this.message=message;
    }


}
