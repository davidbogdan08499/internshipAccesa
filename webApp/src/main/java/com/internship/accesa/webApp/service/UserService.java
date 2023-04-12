package com.internship.accesa.webApp.service;

import com.internship.accesa.webApp.exception.UserNotAvailableServiceException;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.repository.model.UserModel;

import java.util.List;

/**
 * Services used for working with quests.
 */

public interface UserService {
    /**
     * Create and add a user on databse.
     * @param userModel contains data from user.(Object of type {@link  UserModel} used for CRUD op)
     */
    void createUser(UserModel userModel);

    /**
     * Modify the number of tokens.
     * @param tokens number of tokens that you add/subtract
     * @param id of the user
     */
    void modifyToknesUser(int tokens, int id);

    /**
     * Get current user by id.
     * @param id id of the user
     * @return a list of type {@link UserModel} that should contain just one element.
     */
    List<UserModel> getCurrentUser(int id);

    /**
     * Get a user by username.
     * @param username a String that contains the username of the searched user
     * @return an object of type  {@link UserModel} from the database
     * @throws UserNotAvailableServiceException custom exception to handle the unexpected
     */
    UserModel getUserByUsername(String username) throws UserNotAvailableServiceException;

    /**
     *Modify user's badge
     * @param userModel object of type {@link UserModel} that contains data from user.
     */
    void modifyUserBadge(UserModel userModel);

    /**
     *Get ranking position of user by his id.
     * @param id an int that contains id of the user
     * @return an int that represents his rank position
     */
    int getRankingPositionOfUser(int id);

    /**Convert an object of type{@link UserModel} to an object of type {@link UserData}
     *
     * @param userModel contains an object of type{@link UserModel }
     * @return an object of type {@link UserData}
     */
    UserData getUserDataFromUserModel(UserModel userModel);

    /**Convert an object of type{@link UserData} to an object of type {@link UserModel}
     *
     * @param userData contains an object of type{@link UserData}
     * @return an object of type {@link UserModel}
     */
    UserModel getUserModelFromUserData(UserData userData);
}
