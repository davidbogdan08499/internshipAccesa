package com.internship.accesa.webApp.service.impl;

import com.internship.accesa.webApp.exception.UserCreationServiceException;
import com.internship.accesa.webApp.exception.UserNotAvailableServiceException;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.repository.model.UserModel;
import com.internship.accesa.webApp.repository.UserDAO;
import com.internship.accesa.webApp.service.UserService;
import org.hibernate.query.sqm.UnknownEntityException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class DefaultUserService implements UserService {

    private UserDAO userDAO;

    public DefaultUserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void createUser(UserModel userModel) {
        boolean isUserSaved = getUserDAO().saveUser(userModel);
        if (!isUserSaved) {
            throw new UserCreationServiceException("User cannot be created!");
        }
    }

    @Override
    public void modifyToknesUser(int tokens, int id) {
        userDAO.modifyTokensUser(tokens, id);
    }

    @Override
    public List<UserModel> getCurrentUser(int id) {
        return userDAO.getCurrentUser(id);
    }

    @Override
    public UserModel getUserByUsername(String username) throws UserNotAvailableServiceException {
        final List<UserModel> users = userDAO.getUserByUsername(username);
        if (CollectionUtils.isEmpty(users)) {
            throw new UserNotAvailableServiceException("User does not exists");
        }

        return users.get(0);
    }

    @Override
    public void modifyUserBadge(UserModel userModel) {
        userDAO.modifyBadgeUser(userModel);
    }

    @Override
    public int getRankingPositionOfUser(int id) {
        return userDAO.getRankingPositionOfUser(id);
    }

    @Override
    public UserData getUserDataFromUserModel(UserModel userModel) {
        UserData userData = new UserData();
        userData.setId(userModel.getId());
        userData.setUsername(userModel.getUsername());
        userData.setPassword(userModel.getPassword());
        userData.setMail(userModel.getMail());
        userData.setTokens(userModel.getTokens());
        userData.setQuestDataSet(userModel.getQuestDataSet());
        userData.setBadge(userModel.getBadge());
        return userData;
    }

    @Override
    public UserModel getUserModelFromUserData(UserData userData) {
        UserModel userModel = new UserModel();
        userModel.setId(userData.getId());
        userModel.setUsername(userData.getUsername());
        userModel.setPassword(userData.getPassword());
        userModel.setConfirmPassword("");
        userModel.setMail(userData.getMail());
        userModel.setTokens(userData.getTokens());
        userModel.setQuestDataSet(userData.getQuestDataSet());
        userModel.setBadge(userData.getBadge());

        return userModel;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

}
