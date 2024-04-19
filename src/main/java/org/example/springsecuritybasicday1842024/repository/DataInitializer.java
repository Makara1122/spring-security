package org.example.springsecuritybasicday1842024.repository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.springsecuritybasicday1842024.model.Authority;
import org.example.springsecuritybasicday1842024.model.Role;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final RoleRepository roleRepository;
    private final AuthorityRepository authorityRepository;

    @PostConstruct
    void initData(){
        initAuthorities();
        initRoles();
    }

    private void initAuthorities(){

        List<String> authorities = List.of("READ", "WRITE", "DELETE");

        if (authorityRepository.count() == 0){
            for(String authority : authorities) {
                Authority authority1 = new Authority();
                authority1.setName(authority);
                authorityRepository.save(authority1);
            }
        }
    }

    private void initRoles(){

        List<String> roles = List.of("USER", "ADMIN");

        if (roleRepository.count() == 0){
            Role userRole = new Role();
            userRole.setName("USER");
            userRole.setAuthorities(Set.of(authorityRepository.findByName("READ").get()));

            roleRepository.save(userRole);
            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            adminRole.setAuthorities(new HashSet<>(authorityRepository.findAll()));
            roleRepository.save(adminRole);
        }
    }
}
