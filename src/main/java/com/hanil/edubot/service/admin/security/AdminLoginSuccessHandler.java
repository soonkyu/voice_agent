package com.hanil.edubot.service.security;

import com.hanil.edubot.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String url = "/";

        switch (authentication.getAuthorities().toString()) {
            case "[ROLE_COMPANY_ADMIN]":
                url="/admin/users";
                break;
            case "[ROLE_EDU_ADMIN]":
                if(((EduBotDetails)authentication.getPrincipal()).isFirstLogin())
                    url="/pwModify";
                else
                    url="/scripts";
                break;
        }

        setDefaultTargetUrl(url);

        request.getSession().setMaxInactiveInterval(10800);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
