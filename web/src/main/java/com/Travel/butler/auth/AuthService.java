package com.Travel.butler.auth;

import com.Travel.butler.domain.Sysuser;

public interface AuthService {
    Sysuser register(Sysuser userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
