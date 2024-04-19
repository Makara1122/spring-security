package org.example.springsecuritybasicday1842024.repository;

import org.example.springsecuritybasicday1842024.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    boolean existsByEmail(String email);
}
