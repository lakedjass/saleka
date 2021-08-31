package com.saleka.application.oauth2;

import com.saleka.application.security.User;
import com.saleka.application.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        CustomOAuth2User customOAuth2User = (CustomOAuth2User) authentication.getPrincipal();
        String email = customOAuth2User.getEmail();
        String name = customOAuth2User.getName();
        User user = userService.findUserByEmail(email);

        if(user == null){
            //register a new user
            userService.registerNewUserAfterOAuthLoginSuccess(email , name , AuthenticationProvider.GOOGLE);
        }else{
            //update a user

        }

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
