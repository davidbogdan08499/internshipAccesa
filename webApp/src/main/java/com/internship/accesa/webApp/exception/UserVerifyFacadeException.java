package com.internship.accesa.webApp.exception;

public class UserVerifyFacadeException extends RuntimeException {
    public UserVerifyFacadeException(String message, String page) {
        super(message);
        page = "redirect:home";
    }


}
