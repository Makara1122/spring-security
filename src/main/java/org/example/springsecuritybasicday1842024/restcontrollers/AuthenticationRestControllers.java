package org.example.springsecuritybasicday1842024.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRestControllers {

    @GetMapping("/login")
    public String login() {
        return "login successfully";
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "sign-up successfully";
    }
}
