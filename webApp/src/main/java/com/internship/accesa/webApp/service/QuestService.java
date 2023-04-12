package com.internship.accesa.webApp.service;

import com.internship.accesa.webApp.facade.data.QuestData;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.repository.model.QuestModel;
import com.internship.accesa.webApp.repository.model.UserModel;

import java.util.List;

/**
 * Services used for working with quests
 */
public interface QuestService {

    /**
     * Creates a quest and stores it in database
     * @param questModel contains data for the current quest from Quest Form
     */
    void createQuest(QuestModel questModel);

    /**
     * Get a list of quests by id of the
     * creator
     * @param currentUser containts data about the current user
     * @return a list of object of type {@link QuestModel}
     */
    List<QuestModel> getQuestsById(UserData currentUser);

    /**
     *Get a quest by its id
     * @param id a String that contains the id of one quest
     * @return an object of type{@link QuestModel}
     */

    QuestModel getChosenQuestById(String id);
    /**
     * Convert an object of type {@link QuestData} in an object of type{@link QuestModel}
     * @param questData object that contains data about the user(used in facade services for business logic )
     * @return object of type {@link QuestData} (used in CRUD operations on database)
     */


    QuestModel getQuestModelFromQuestData(QuestData questData);

    /**
     * Convert an object of type {@link QuestModel} in an object of type{@link QuestData}
     * @param questModel object that contains data about the user(used in CRUD operations on database )
     * @return object of type {@link QuestData} (used in facade services for business logic)
     */
    QuestData getQuestDataFromQuestModel(QuestModel questModel);

    /**
     * Get quest service
     * @return an object of type {@link QuestService}
     */
    QuestService getQuestService();

}
