package com.internship.accesa.webApp.controller;

import com.internship.accesa.webApp.facade.QuestFacade;
import com.internship.accesa.webApp.facade.data.UserData;
import com.internship.accesa.webApp.repository.model.QuestModel;
import com.internship.accesa.webApp.repository.model.UserModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/liveQuests")
public class LiveQuestsPageController {

    public static String LIVE_QUESTS_PAGE = "livequestsPage";
    private QuestFacade questFacade;
    private List<QuestModel> questModelList = new ArrayList<>();

    private static final String HOME_PAGE = "home";

    public LiveQuestsPageController(QuestFacade questFacade) {
        this.questFacade = questFacade;
    }

    @GetMapping()
    public String getPage(HttpServletRequest httpServletRequest, Model model) {
        if (httpServletRequest.getSession().getAttribute("user") == null) {
            return HOME_PAGE;
        }
        UserData currentUser = (UserData) httpServletRequest.getSession().getAttribute("user");
        questModelList = questFacade.getQuestsByCriteria(currentUser);
        model.addAttribute("questDataList", questModelList);


        return LIVE_QUESTS_PAGE;
    }
}
