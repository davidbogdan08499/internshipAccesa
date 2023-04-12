package com.internship.accesa.webApp.service.impl;

import com.internship.accesa.webApp.facade.data.QuestData;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.repository.QuestDAO;
import com.internship.accesa.webApp.repository.model.QuestModel;
import com.internship.accesa.webApp.repository.model.UserModel;
import com.internship.accesa.webApp.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class DefaultQuestServiceTest {

    private static final String ID="idQuest";
    @Mock
    private QuestDAO questDAO;

    @Mock
    private UserService userService;

    @Mock
    private QuestData questData;

    @Mock
    private UserData userData;

    @Mock
    private UserModel userModel;

    @Before
    public void setUp(){
        when(userService.getUserModelFromUserData(userData)).thenReturn(userModel);
    }

    @InjectMocks
    private DefaultQuestService questService;


    @Test
    public void testGetChosenQuestById(){
        questDAO.getChosenQuestById(ID);
    }

    @Test
    public void testGetQuestsById(){
        questDAO.getQuestsByCriteria(userModel);
    }
}
