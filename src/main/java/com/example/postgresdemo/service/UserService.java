package com.example.postgresdemo.service;

import com.example.postgresdemo.dto.UserData;
import com.example.postgresdemo.exception.UserAlreadyExistsException;
import com.example.postgresdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.postgresdemo.model.User;

@Service("userService")
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User register(UserData userData) throws UserAlreadyExistsException {
        if (checkIfUserExist(userData.getEmail())) {
            throw new UserAlreadyExistsException(userData);
        }

        final User userEntity = new User();
        userEntity.setFirstName(userData.getFirstName());
        userEntity.setLastName(userData.getLastName());
        userEntity.setEmail(userData.getEmail());
        userEntity.setPassword(passwordEncoder.encode(userData.getPassword()));
        return userRepository.save(userEntity);
    }

    private boolean checkIfUserExist(final String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
