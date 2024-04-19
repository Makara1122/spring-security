package org.example.springsecuritybasicday1842024.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "roles_tbl")

@Getter
@Setter
@NoArgsConstructor
// make our code to be pojo class

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String description;

    @ManyToMany
    Set<Authority> authorities;
}
