package com.hanil.edubot.module.member.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String memberLoginView(){

        return "/login";
    }
}
