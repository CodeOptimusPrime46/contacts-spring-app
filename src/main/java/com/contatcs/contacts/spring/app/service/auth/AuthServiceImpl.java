package com.contatcs.contacts.spring.app.service.auth;

import com.contatcs.contacts.spring.app.model.Users;
import com.contatcs.contacts.spring.app.repository.UserRepository;
import java.util.Base64;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;

    @Autowired
    AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String[] getUserNameAndPassword(String authHeader) {
        String usernameAndPassword = authHeader.split(" ")[1];
        byte[] decoder = Base64.getDecoder().decode(usernameAndPassword);
        return new String(decoder).split(":");
    }

    @Override
    public boolean isAuthenticated(String authHeader) {
        String[] userNameAndPassword = getUserNameAndPassword(authHeader);
        Optional<Users> users = userRepository.findUsersByUsernameAndPassword(userNameAndPassword[0], userNameAndPassword[1]);
        return users.isPresent();
    }
}
