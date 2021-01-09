package com.example.oauth2service.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizationSuccessHandler;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler
{
    @Autowired
    OAuth2AuthorizedClientService clientService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException
    {
        System.out.println("wywolana");
        Authentication a =
                SecurityContextHolder
                        .getContext()
                        .getAuthentication();

        OAuth2AuthenticationToken oauthToken =
                (OAuth2AuthenticationToken) authentication;
        OAuth2AuthorizedClient client =
                clientService.loadAuthorizedClient(
                        oauthToken.getAuthorizedClientRegistrationId(),
                        oauthToken.getName());

        String accessToken = client.getAccessToken().getTokenValue();
        System.out.println(accessToken);
        System.out.println(a.getPrincipal());
    }
}
