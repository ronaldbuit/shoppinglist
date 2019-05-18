package net.buit.shoppinglist.controller;

import net.buit.shoppinglist.config.AppProperties;
import net.buit.shoppinglist.config.SecurityConfig;
import net.buit.shoppinglist.config.WebMvcConfig;
import net.buit.shoppinglist.model.User;
import net.buit.shoppinglist.repository.UserRepository;
import net.buit.shoppinglist.security.TokenProvider;
import net.buit.shoppinglist.security.oauth2.OAuth2AuthenticationFailureHandler;
import net.buit.shoppinglist.security.oauth2.OAuth2AuthenticationSuccessHandler;
import net.buit.shoppinglist.security.oauth2.user.CustomOAuth2UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = {UserController.class, TestCustomUserDetailsService.class, SecurityConfig.class,
        WebMvcConfig.class, AppProperties.class})
public class UserControllerTest {

    @MockBean
    UserRepository userRepository;

    @MockBean
    CustomOAuth2UserService customOAuth2UserService;

    @MockBean
    OAuth2AuthenticationSuccessHandler oauth2AuthenticationSuccessHandler;

    @MockBean
    OAuth2AuthenticationFailureHandler oauth2AuthenticationFailureHandler;

    @MockBean
    ClientRegistrationRepository clientRegistrationRepository;

    @MockBean
    TokenProvider tokenProvider;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithUserDetails(value = "test")
    public void getCurrentUser_return_user() throws Exception {

        User user = new User();
        user.setId(1l);
        user.setEmail("test@test.com");
        user.setName("test");
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(user));

        MvcResult result = mockMvc.perform(get("/user/me").contentType(MediaType.APPLICATION_JSON)).andReturn();

        assertThat(result).isNotNull();
        
        String content = result.getResponse().getContentAsString();
    }
}
