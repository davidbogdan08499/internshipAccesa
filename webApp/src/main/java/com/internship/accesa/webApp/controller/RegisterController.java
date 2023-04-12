package com.internship.accesa.webApp.controller;


import com.internship.accesa.webApp.facade.UserFacade;
import com.internship.accesa.webApp.repository.model.UserModel;
import com.internship.accesa.webApp.facade.exception.FacadeException;
import com.internship.accesa.webApp.forms.BADGES;
import com.internship.accesa.webApp.validator.RegisterFormValidator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.internship.accesa.webApp.forms.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

@Controller

@RequestMapping("")
public class RegisterController {

    private static final String REGISTER_PAGE = "register";
    private static final String LOGIN_PAGE = "login";

    private static final String MAIN_PAGE_APP = "redirect:";


    private final UserFacade userFacade;

    private final RegisterFormValidator registerFormValidator;

    @Autowired
    public RegisterController(UserFacade userFacade,RegisterFormValidator registerFormValidator) {
        this.userFacade = userFacade;
        this.registerFormValidator = registerFormValidator;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        RegisterForm registerForm = new RegisterForm();
        model.addAttribute("registerForm", registerForm);
        return REGISTER_PAGE;
    }

    @PostMapping("/requestRegister")
    public String getAppMainPage(@Valid @ModelAttribute("registerForm") RegisterForm registerForm
            , BindingResult bindingResult
            , HttpServletRequest httpServletRequest,Model model) throws NoSuchAlgorithmException, InvalidKeySpecException {

        registerFormValidator.validate(registerForm,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute(registerForm);
            return REGISTER_PAGE;
        }

        final UserModel userModel = new UserModel();
        userModel.setQuestDataSet(new ArrayList<>());
        userModel.setMail(registerForm.getMail());
        userModel.setUsername(registerForm.getUsername());
        userModel.setPassword(registerForm.getPassword());
        userModel.setConfirmPassword(registerForm.getConfirmPassword());
        userModel.setTokens(50);
        if(userModel.getUsername().equals("admin")){
            userModel.setBadge(BADGES.ADMIN.toString());
        }else{
            userModel.setBadge(BADGES.ENTHUSIAST.toString());
        }
        try {
            userFacade.createUser(userModel);
            httpServletRequest.getSession().setAttribute("user", userFacade.getUserService().getUserDataFromUserModel(userModel));
            return MAIN_PAGE_APP;
        } catch (FacadeException ex) {
            return "redirect:" + LOGIN_PAGE;
        }
    }

    /*
    private void hashPasswword(RegisterForm registerForm) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //generate salt value
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = secureRandom.generateSeed(12);

        //hash password
        PBEKeySpec pbeKeySpec =
                new PBEKeySpec(registerForm.getPassword().toCharArray(), salt, 10, 512);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
        byte[] hash = secretKeyFactory.generateSecret(pbeKeySpec).getEncoded();
        registerForm.setPassword(Base64.getMimeEncoder().encodeToString(hash));
        registerForm.setConfirmPassword(Base64.getMimeEncoder().encodeToString(hash));
    }

     */
}
