package com.contatcs.contacts.spring.app.service.auth;

public interface AuthService {

    boolean isAuthenticated(String authHeader);

}
