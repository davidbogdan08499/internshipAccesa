package com.internship.accesa.webApp.controller;


import com.internship.accesa.webApp.facade.UserFacade;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.facade.exception.FacadeException;
import com.internship.accesa.webApp.forms.LoginForm;
import com.internship.accesa.webApp.validator.LoginFormValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static com.internship.accesa.webApp.constants.ConstantsVariables.REDIRECT_PREFIX;

@Controller
@RequestMapping("")
public class LoginController {
    private static final String LOGIN_FORM = "login";

    private static final String HOME_PAGE = "home";

    private final UserFacade userFacade;

    private final LoginFormValidator customValidator;

    public LoginController(UserFacade userFacade, LoginFormValidator customValidator) {
        this.userFacade = userFacade;
        this.customValidator = customValidator;
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm());

        return LOGIN_FORM;
    }

    @PostMapping("/requestLogin")
    public String getAppMainPage(@Valid @ModelAttribute("loginForm") LoginForm loginForm,
                                 BindingResult bindingResult, HttpServletRequest httpServletRequest, Model model) {
        UserData searchedUser;
        customValidator.validate(loginForm, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute(loginForm);
            return LOGIN_FORM;
        }
        try {
            searchedUser = userFacade.getUserByUsername(loginForm.getUsername());
        } catch (FacadeException exception) {
            return REDIRECT_PREFIX + HOME_PAGE;
        }
        if (!searchedUser.getPassword().equals(loginForm.getPassword())) {
            return REDIRECT_PREFIX + LOGIN_FORM;
        }
        httpServletRequest.getSession().setAttribute("user", searchedUser);
        return REDIRECT_PREFIX;
    }
}


