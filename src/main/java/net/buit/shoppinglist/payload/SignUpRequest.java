package net.buit.shoppinglist.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class SignUpRequest {

    @NotBlank
    @Getter @Setter
    private String name;

    @NotBlank
    @Email
    @Getter @Setter
    private String email;

    @NotBlank
    @Getter @Setter
    private String password;
}