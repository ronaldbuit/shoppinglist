package net.buit.shoppinglist.controller;

import net.buit.shoppinglist.model.User;
import net.buit.shoppinglist.security.CustomUserDetailsService;
import net.buit.shoppinglist.security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TestCustomUserDetailsService extends CustomUserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = new User();
        user.setId(1l);
        user.setEmail(email);
        user.setName(email);

        return UserPrincipal.create(user);
    }
}
