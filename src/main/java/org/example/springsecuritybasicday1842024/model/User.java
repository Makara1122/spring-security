package org.example.springsecuritybasicday1842024.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity

@Getter
@Setter
@NoArgsConstructor
// make our code to be pojo class

@Table(name = "users_tbl")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String email;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    Set<Role> roles;


}
