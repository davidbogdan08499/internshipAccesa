package com.internship.accesa.webApp.facade.impl;

import com.internship.accesa.webApp.facade.data.QuestData;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.repository.model.QuestModel;
import com.internship.accesa.webApp.service.QuestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class DefaultQuestFacadeTest {

    @Mock
    private QuestService questService;

    @InjectMocks
    private DefaultQuestFacade questFacade;

    @Mock
    private QuestData questData;

    @Mock
    private QuestModel questModel;

    @Mock
    private UserData userData;

    @Before
    public void setUp() {
        when(questService.getQuestModelFromQuestData(questData)).thenReturn(questModel);    }

    @Test
    public void testCreateQuest() {
      questFacade.createQuest(questData);

      verify(questService, times(1)).createQuest(questModel);
    }

    @Test
    public void testGetStatusOFCreateQuestButtonWhenTokensExceed(){
        when(userData.getTokens()).thenReturn(98);
        assertTrue(questFacade.getStatusOFCreateQuestButton(userData));
    }

    @Test
    public void testGetStatusOFCreateQuestButtonWhenTokensLower(){
        when(userData.getTokens()).thenReturn(94);
        assertFalse(questFacade.getStatusOFCreateQuestButton(userData));
    }



}


