package com.grocery.booking.Model.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginUserResponse {
    private String token;

    public LoginUserResponse(String token) {
        this.token = token;
    }
}
