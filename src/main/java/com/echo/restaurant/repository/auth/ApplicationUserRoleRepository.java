package com.echo.restaurant.repository.auth;

import com.echo.restaurant.entity.auth.ApplicationUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRoleRepository extends JpaRepository<ApplicationUserRole, Long> {
    Optional<ApplicationUserRole> findFirstByNameIgnoreCase(String name);
}
