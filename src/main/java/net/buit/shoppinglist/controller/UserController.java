package net.buit.shoppinglist.controller;

import net.buit.shoppinglist.exception.ResourceNotFoundException;
import net.buit.shoppinglist.model.User;
import net.buit.shoppinglist.repository.UserRepository;
import net.buit.shoppinglist.security.CurrentUser;
import net.buit.shoppinglist.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
