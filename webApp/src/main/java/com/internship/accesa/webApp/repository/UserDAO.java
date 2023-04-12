package com.internship.accesa.webApp.repository;

import com.internship.accesa.webApp.repository.model.UserModel;

import java.util.List;

/**
 * Interface for working with users and database.
 */
public interface UserDAO {
    /**
     * Save a user
     * @param userModel an object of type {@link  UserModel}.
     * @return a boolean that indicates true if the user have been saved succesfully
     *         or false if not.
     */
    public boolean saveUser(UserModel userModel);

    /**
     * Modify the number of tokens of the user.
     * @param tokens number of tokens that will be added/subtracted
     * @param id id of the searched user for this operation
     */
    void modifyTokensUser(int tokens, int id);

    /**
     * Get current user by id
     * @param id the id of the searched user
     * @return a list of type {@link UserModel} that should contain only one element
     */
    List<UserModel> getCurrentUser(int id);

    /**
     * Get current user by username
     * @param username a string that contains the username of user
     * @return a list of type {@link UserModel} that should contain only one element
     */
    List<UserModel> getUserByUsername(String username);

    /**
     * Modify the badge of the user
     * @param userModel an object of type{@link UserModel} wich contains data about searched user
     */
    void modifyBadgeUser(UserModel userModel);

    /**
     * Get ranking posistion of user by id
     * @param id an integer that contains the id of a searched user
     * @return
     */
    int getRankingPositionOfUser(int id);
}
