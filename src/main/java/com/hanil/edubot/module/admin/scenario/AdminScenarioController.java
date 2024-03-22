package com.hanil.edubot.module.admin.scenario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/scenario")
public class ScenarioController {

    @RequestMapping("")
    public String scenarioListView(){

        return "/admin/scenario/scripts";
    }
}
