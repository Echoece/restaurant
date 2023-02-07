package com.echo.restaurant.config.auth;

import com.echo.restaurant.entity.auth.ApplicationUser;
import com.echo.restaurant.repository.auth.ApplicationUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final ApplicationUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return userRepository.getApplicationUserByEmail(email)
                .map(this::createUser)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User name %s not found", email)));
    }

    // ROLE_ prefix is added to each role
    private MyUserDetails createUser(ApplicationUser user){
        Set<SimpleGrantedAuthority> authorities = user.getRoles().stream()
                .map(userRole -> new SimpleGrantedAuthority("ROLE_" + userRole.getName()))
                .collect(Collectors.toSet());

        return MyUserDetails.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(authorities)
                .accountNonLocked(true)
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
    }
}
