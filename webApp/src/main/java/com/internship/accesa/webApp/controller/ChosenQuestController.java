package com.internship.accesa.webApp.controller;

import com.internship.accesa.webApp.constants.ConstantsVariables;
import com.internship.accesa.webApp.facade.QuestFacade;
import com.internship.accesa.webApp.facade.UserFacade;
import com.internship.accesa.webApp.facade.data.QuestData;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.forms.QuestAnswer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class ChosenQuestController {

    public static final String CHOSEN_QUEST_PAGE = "chosenQuest";

    public static final String URL_HOME_PAGE = "http://localhost:8082/";

    private final UserFacade userFacade;
    private final QuestFacade questFacade;

    public ChosenQuestController(QuestFacade questFacade, UserFacade userFacade) {
        this.questFacade = questFacade;
        this.userFacade = userFacade;
    }

    @GetMapping("/mainPageApp/liveQuests/quest")
    public String getPage(HttpServletRequest httpServletRequest, Model model, @RequestParam String id) {
        QuestAnswer questAnswer = new QuestAnswer();
        QuestData questChosen = questFacade.getQuestService().getQuestDataFromQuestModel(questFacade.getChosenQuestById(id));
        model.addAttribute("chosenQuest", questChosen);
        httpServletRequest.getSession().setAttribute("chosenQuest", questChosen);
        model.addAttribute("questAnswer", questAnswer);

        return CHOSEN_QUEST_PAGE;
    }

    @PostMapping("/mainPageApp/liveQuests/quest")
    public RedirectView getResponseFromPage(HttpServletRequest httpServletRequest
            , @Valid @ModelAttribute("questAnswer") QuestAnswer questAnswer) {
        QuestData questChosen = (QuestData) httpServletRequest.getSession().getAttribute("chosenQuest");
        UserData currentUser = (UserData) httpServletRequest.getSession().getAttribute("user");
        if (questAnswer.getQuestAnswerValue() == questChosen.getIdCorrectAnswer()) {
            userFacade.modifyTokensUser(ConstantsVariables.NUMBER_OF_TOKENS_TO_MODIFY_FOR_CREATOR
                    , questChosen.getUser().getId());
            userFacade.modifyTokensUser(ConstantsVariables.NUMBER_OF_TOKENS_TO_MODIFY_FOR_RESOLVER
                    , currentUser.getId());
            userFacade.modifyBadgeUser(userFacade.getUserService().getUserModelFromUserData(questChosen.getUser()));
            userFacade.modifyBadgeUser(userFacade.getUserService().getUserModelFromUserData(currentUser));
        }

        return new RedirectView(URL_HOME_PAGE);
    }
}
