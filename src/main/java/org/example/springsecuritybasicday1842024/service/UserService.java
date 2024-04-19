package org.example.springsecuritybasicday1842024.service;

import org.example.springsecuritybasicday1842024.model.User;
import org.example.springsecuritybasicday1842024.model.dto.UserRequest;
import org.example.springsecuritybasicday1842024.model.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
}
