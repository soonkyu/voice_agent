package com.hanil.edubot.module.admin.login;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Qualifier("adminLoginController")
@RequestMapping("/admin")
public class LoginController {

    @GetMapping("/login")
    public String loginView(){
        return "/admin/login";
    }

}
