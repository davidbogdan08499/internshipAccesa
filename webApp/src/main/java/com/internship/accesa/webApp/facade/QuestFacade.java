package com.internship.accesa.webApp.facade;

import com.internship.accesa.webApp.facade.data.QuestData;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.repository.model.QuestModel;
import com.internship.accesa.webApp.service.QuestService;

import java.util.List;

/**
 * Interface for creating new quest
 */
public interface QuestFacade {

    /**
     * Creates a quest for given form
     *
     * @param questData contains data from form
     */
    void createQuest(QuestData questData);

    /**
     * Returns list of {@link QuestModel} based on current {@link UserData}.
     *
     * @param currentUser the current user
     * @return list of quests for current user
     */
    List<QuestModel> getQuestsByCriteria(UserData currentUser);

    /**
     * Returns an object of{@link QuestModel} based on current id.
     * @param id id of searched quest
     * @return a quest object
     */

    QuestModel getChosenQuestById(String id);

    /**
     *
     * @return an object of QuestService type
     */
    QuestService getQuestService();

    /**
     * Get a boolean value that indicates if the CREATE QUEST BUTTON should
     * be visible or not
     * @param userData object of {@link  UserData}  that indicates the current user
     * @return a boolean value
     */
    boolean getStatusOFCreateQuestButton(UserData userData);

}
