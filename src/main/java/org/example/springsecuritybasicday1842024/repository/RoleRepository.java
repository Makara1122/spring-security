package org.example.springsecuritybasicday1842024.repository;

import org.example.springsecuritybasicday1842024.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
