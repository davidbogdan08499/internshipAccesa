package com.internship.accesa.webApp.facade.impl;

import com.internship.accesa.webApp.exception.UserNotAvailableServiceException;
import com.internship.accesa.webApp.facade.UserFacade;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.repository.model.UserModel;
import com.internship.accesa.webApp.facade.exception.FacadeException;
import com.internship.accesa.webApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultUserFacade implements UserFacade {

    private final UserService userService;

    @Autowired
    public DefaultUserFacade(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void createUser(UserModel userModel) {
        try {
            getUserService().getUserByUsername(userModel.getUsername());
            throw new FacadeException("User already exists");
        } catch (UserNotAvailableServiceException e) {
            getUserService().createUser(userModel);
        }
    }

    @Override
    public void modifyTokensUser(int tokens, int id) {
        userService.modifyToknesUser(tokens, id);
    }

    @Override
    public List<UserModel> getCurrentUser(int id) {
        return userService.getCurrentUser(id);
    }

    @Override
    public UserData getUserByUsername(String username) {
        try {
            UserModel user = userService.getUserByUsername(username);
            return userService.getUserDataFromUserModel(user);
        } catch (UserNotAvailableServiceException ex) {
            throw new FacadeException(ex.getMessage());
        }
    }

    @Override
    public void modifyBadgeUser(UserModel userModel) {
        userService.modifyUserBadge(userModel);
    }

    @Override
    public int getRankingPositionofUser(int id) {
        return userService.getRankingPositionOfUser(id);
    }


    public UserService getUserService() {
        return userService;
    }

}
