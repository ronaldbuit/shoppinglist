package net.buit.shoppinglist.payload;

import lombok.Getter;
import lombok.Setter;

public class AuthResponse {

    @Getter @Setter
    private String accessToken;

    @Getter @Setter
    private String tokenType = "Bearer";

    public AuthResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
