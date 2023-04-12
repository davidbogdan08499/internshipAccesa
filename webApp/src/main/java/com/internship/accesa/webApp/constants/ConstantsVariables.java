package com.internship.accesa.webApp.constants;

import org.springframework.stereotype.Component;

@Component
public class ConstantsVariables {
    public static final int MINIMUM_TOKENS_FOR_CREATING_REQUEST=95;
    public static final int NUMBER_OF_TOKENS_FOR_CREATING_QUEST=-5;
    public static final String REDIRECT_PREFIX = "redirect:";

    public static final String USERNAME_ERROR_MESSAGE="username.required";

    public static final int NUMBER_OF_TOKENS_TO_MODIFY_FOR_CREATOR=10;

    public static final int NUMBER_OF_TOKENS_TO_MODIFY_FOR_RESOLVER=5;
    public static final String PASSWORD_ERROR_MESSAGE ="password.required" ;
}
