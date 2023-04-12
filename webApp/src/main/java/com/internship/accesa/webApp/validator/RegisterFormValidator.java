package com.internship.accesa.webApp.validator;

import com.internship.accesa.webApp.constants.ConstantsVariables;
import com.internship.accesa.webApp.forms.RegisterForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for Register Form
 */
@Component
public class RegisterFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterForm registerForm=(RegisterForm)target;
        String username=registerForm.getUsername();
        String password=registerForm.getPassword();
        String confirmPassword=registerForm.getConfirmPassword();
        String mail=registerForm.getMail();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",ConstantsVariables.USERNAME_ERROR_MESSAGE);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password",ConstantsVariables.PASSWORD_ERROR_MESSAGE);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"confirmPassword",ConstantsVariables.CONFIRM_PASSWORD_ERROR_MESSAGE);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"mail",ConstantsVariables.MAIL_ERROR_MESSAGE);
    }
}
