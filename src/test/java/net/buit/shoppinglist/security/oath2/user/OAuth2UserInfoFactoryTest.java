package net.buit.shoppinglist.security.oath2.user;

import net.buit.shoppinglist.exception.OAuth2AuthenticationProcessingException;
import net.buit.shoppinglist.model.AuthProvider;
import net.buit.shoppinglist.security.oauth2.user.OAuth2UserInfo;
import net.buit.shoppinglist.security.oauth2.user.OAuth2UserInfoFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class OAuth2UserInfoFactoryTest {

    @Test(expected = OAuth2AuthenticationProcessingException.class)
    public void getOAuth2UserInfo_incorrect_registrationId_throws_exception()
    {
        OAuth2UserInfoFactory.getOAuth2UserInfo("incorrect", null);
    }

    @Test
    public void getOAuth2UserInfo_google_()
    {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("sub", "Id");
        attributes.put("name", "Name");
        attributes.put("email", "Email");
        attributes.put("picture", "ImageUrl");

        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(AuthProvider.GOOGLE.toString(), attributes);

        assertThat(oAuth2UserInfo.getId()).isEqualTo("Id");
        assertThat(oAuth2UserInfo.getName()).isEqualTo("Name");
        assertThat(oAuth2UserInfo.getEmail()).isEqualTo("Email");
        assertThat(oAuth2UserInfo.getImageUrl()).isEqualTo("ImageUrl");
    }
}
