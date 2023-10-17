package com.melolingo.app.repo;

import com.melolingo.app.models.Role;
import com.melolingo.app.models.Role.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByName(ERole name);
}