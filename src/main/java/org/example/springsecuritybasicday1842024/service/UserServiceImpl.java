package org.example.springsecuritybasicday1842024.service;

import lombok.RequiredArgsConstructor;
import org.example.springsecuritybasicday1842024.mapper.UserMapper;
import org.example.springsecuritybasicday1842024.model.Role;
import org.example.springsecuritybasicday1842024.model.User;
import org.example.springsecuritybasicday1842024.model.dto.UserRequest;
import org.example.springsecuritybasicday1842024.model.dto.UserResponse;
import org.example.springsecuritybasicday1842024.repository.RoleRepository;
import org.example.springsecuritybasicday1842024.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public UserResponse createUser(UserRequest userRequest) {

        if (userRepository.existsByEmail(userRequest.email())) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists");
        }

        Set<Role> roles = new HashSet<>();

        userRequest.roles().forEach(r->{
            var roleObject = roleRepository.findByName(r).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "Role not found"));
        });

        User newUser = userMapper.userRequestToUser(userRequest,roles);
        newUser.setPassword(new BCryptPasswordEncoder().encode(userRequest.password()));
        userRepository.save(newUser);

        return userMapper.toUserResponse(newUser);


    }
}
