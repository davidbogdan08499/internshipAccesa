package com.internship.accesa.webApp.validator;

import com.internship.accesa.webApp.constants.ConstantsVariables;
import com.internship.accesa.webApp.forms.LoginForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Used to validate Login Form.
 */
@Component
public class LoginFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return LoginForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginForm loginForm=(LoginForm) target;
        String username=loginForm.getUsername();
        String password=loginForm.getPassword();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username",ConstantsVariables.USERNAME_ERROR_MESSAGE);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password",ConstantsVariables.PASSWORD_ERROR_MESSAGE);
    }
}
