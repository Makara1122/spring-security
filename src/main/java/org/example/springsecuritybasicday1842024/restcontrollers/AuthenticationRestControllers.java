package org.example.springsecuritybasicday1842024.restcontrollers;

import lombok.RequiredArgsConstructor;
import org.example.springsecuritybasicday1842024.model.dto.UserRequest;
import org.example.springsecuritybasicday1842024.model.dto.UserResponse;
import org.example.springsecuritybasicday1842024.service.UserService;
import org.example.springsecuritybasicday1842024.utils.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationRestControllers {

    private final UserService userService;

    @PostMapping("/register")
    public BaseResponse<UserResponse> register(@RequestBody UserRequest userRequest){
        return BaseResponse.<UserResponse>createSuccess().setPayload(userService.createUser(userRequest));
    }


}
