package org.example.springsecuritybasicday1842024.model.dto;

import lombok.Builder;
import org.example.springsecuritybasicday1842024.model.Role;

import java.util.Set;

@Builder
public record UserRequest(
        String email,
        String password,
        Set<String> roles
) {

}
