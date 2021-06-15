package com.saleka.application.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();


        String redirectURL = request.getContextPath();

        if (userDetails.hasRole("ADMIN")) {
            redirectURL = "/admin/dashboard";
        } else if (userDetails.hasRole("HERO")) {
            redirectURL = "/admin/listConfiguration";
        } else if (userDetails.hasRole("USER")) {
            redirectURL = "/";
        }

        response.sendRedirect(redirectURL);

    }

}