package org.example.springsecuritybasicday1842024.restcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admins")
public class AdminRestController {

    @GetMapping()
    public String getAllUsers() {
        return "These are all the users";
    }
}
