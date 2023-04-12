package com.internship.accesa.webApp.controller;

import com.internship.accesa.webApp.constants.ConstantsVariables;
import com.internship.accesa.webApp.facade.QuestFacade;
import com.internship.accesa.webApp.facade.UserFacade;
import com.internship.accesa.webApp.facade.data.QuestData;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.repository.model.QuestModel;
import com.internship.accesa.webApp.repository.model.UserModel;
import com.internship.accesa.webApp.forms.QuestForm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@Controller
@RequestMapping("/createQuest")
public class CreatQuestPageController {
    public static String CREATE_QUEST_PAGE = "createQuestPage";

    private static final String HOME_PAGE = "home";

    private final QuestFacade questFacade;
    private final UserFacade userFacade;

    @Autowired
    public CreatQuestPageController(QuestFacade questFacade, UserFacade userFacade) {
        this.questFacade = questFacade;
        this.userFacade = userFacade;
    }

    @GetMapping
    public String getQuestPage(Model model, HttpServletRequest httpServletRequest) {
        if (httpServletRequest.getSession().getAttribute("user") == null) {
            return HOME_PAGE;
        }
        QuestForm questForm = new QuestForm();
        UserData userData = (UserData) httpServletRequest.getSession().getAttribute("user");
        model.addAttribute("userData", userData);
        model.addAttribute("questForm", questForm);

        return CREATE_QUEST_PAGE;
    }

    @PostMapping
    public String createQuest(@Valid @ModelAttribute("questForm") QuestForm questForm,
                              HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                              FilterChain filterChain, Model model) {
        UserData userData = (UserData) httpServletRequest.getSession().getAttribute("user");
        model.addAttribute("userData", userData);
        QuestData questData = new QuestData();
        questData.setId(RandomStringUtils.random(6, true, true));
        questData.setQuestion(questForm.getQuestion());
        questData.setAnswerOne(questForm.getAnswerOne());
        questData.setAnswerTwo(questForm.getAnswerTwo());
        questData.setAnswerThree(questForm.getAnswerThree());
        questData.setIdCorrectAnswer(questForm.getIdCorrectAnswer());
        questData.setUser(userData);

        questFacade.createQuest(questData);
        // add created quest to user list
        userData.getQuestDataSet().add(questFacade.getQuestService().getQuestModelFromQuestData(questData));
        userData.setTokens(userData.getTokens() - ConstantsVariables.NUMBER_OF_TOKENS_FOR_CREATING_QUEST);
        userFacade.modifyTokensUser(ConstantsVariables.NUMBER_OF_TOKENS_FOR_CREATING_QUEST, userData.getId());

        return "redirect:";
    }
}
