package com.echo.restaurant.repository.auth;

import com.echo.restaurant.entity.auth.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
