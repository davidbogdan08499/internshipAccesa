package com.internship.accesa.webApp.facade;

import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.repository.model.UserModel;
import com.internship.accesa.webApp.service.UserService;
import org.aspectj.apache.bcel.classfile.Unknown;

import java.util.List;

/**
 * Interface for creating new customer account
 */
public interface UserFacade {
    /**
     * Creates a new user for given form.
     *
     * @param userModel object of {@link UserModel}  contains data from registration form.
     */

    void createUser(UserModel userModel);

    /**
     * Modify the value of an user's tokens.
     * @param tokens number of tokens that you add/subtract
     * @param id   id of the user
     */
    void modifyTokensUser(int tokens, int id);

    /**
     * Get the current user
     * @param id id of one user
     * @return a list of type {@link UserModel} with the given id.This list should contain just one object.
     */
    List<UserModel> getCurrentUser(int id);

    /**
     * Get a user by his username
     * @param username a string that contains the username of the user
     * @return an object of type {@link UserData}
     */
    UserData getUserByUsername(String username);

    /**
     * Modify the badge(after criteria) of the user.
     * @param userModel stores data of the user
     */
    void modifyBadgeUser(UserModel userModel);

    /**
     * Get rank position of the current user by id
     * @param id id of current user
     * @return an integer-ranking position
     */
    int getRankingPositionofUser(int id);

    /**
     *
     * @return an object of type {@link UserService}
     */
    UserService getUserService();
}

