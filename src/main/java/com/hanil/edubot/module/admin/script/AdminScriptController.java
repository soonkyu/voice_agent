package com.hanil.edubot.module.admin.script;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScriptController {

    @GetMapping("/script")
    public String scriptListView(){
        return "/admin/script/script";
    }
}
