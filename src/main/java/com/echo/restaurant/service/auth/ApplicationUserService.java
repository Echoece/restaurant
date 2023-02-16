package com.echo.restaurant.service.auth;

import com.echo.restaurant.config.auth.jwt.JwtConfig;
import com.echo.restaurant.entity.auth.Address;
import com.echo.restaurant.entity.auth.ApplicationUser;
import com.echo.restaurant.entity.auth.ApplicationUserRole;
import com.echo.restaurant.exception.ApiNotAcceptableException;
import com.echo.restaurant.repository.auth.AddressRepository;
import com.echo.restaurant.repository.auth.ApplicationUserRepository;
import com.echo.restaurant.repository.auth.ApplicationUserRoleRepository;
import com.echo.restaurant.utility.Utility;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationUserService {
    private final ApplicationUserRepository applicationUserRepository;
    private final ApplicationUserRoleRepository roleRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    public ApplicationUser save(ApplicationUser payload) throws ApiNotAcceptableException {
        if(payload.getId()!=null)
            throw new ApiNotAcceptableException("id field must be null for save operation");

        ApplicationUserRole roleUser = roleRepository.findFirstByNameIgnoreCase("USER")
                    .orElseThrow(() -> new ApiNotAcceptableException("Role not found"));
        payload.setRoles(Set.of(roleUser));

        return createUser(payload);
    }

    public ApplicationUser saveDeliveryMan(ApplicationUser payload) throws ApiNotAcceptableException {
        if(payload.getId()!=null)
            throw new ApiNotAcceptableException("id field must be null for save operation");

        ApplicationUserRole roleUser = roleRepository.findFirstByNameIgnoreCase("DELIVERYMAN")
                .orElseThrow(() -> new ApiNotAcceptableException("Role not found"));
        payload.setRoles(Set.of(roleUser));

        return createUser(payload);
    }

    public ApplicationUser saveAdmin(ApplicationUser payload) throws ApiNotAcceptableException {
        if(payload.getId()!=null)
            throw new ApiNotAcceptableException("id field must be null for save operation");

        ApplicationUserRole roleUser = roleRepository.findFirstByNameIgnoreCase("ADMIN")
                .orElseThrow(() -> new ApiNotAcceptableException("Role not found"));
        payload.setRoles(Set.of(roleUser));

        return createUser(payload);
    }

    private ApplicationUser createUser(ApplicationUser payload){
        if(payload.getAddress()!=null){
            Address address = null;
            if(payload.getAddress().getId()==null){
                address = addressRepository.save(payload.getAddress());
            }
            if(payload.getAddress().getId()!=null){
                address = addressRepository.findById(payload.getAddress().getId()).orElse(null);
            }
            payload.setAddress(address);
        }
        payload.setPassword(passwordEncoder.encode(payload.getPassword()));

        String token = Jwts.builder()
                .setSubject(payload.getEmail())
                .claim(JwtConfig.AUTHORITIES,List.of( Map.of("authority", payload.getAuthentication())) )
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(
                        LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())
                ))
                .signWith(secretKey)
                .compact();

        payload.setToken(token);

        return applicationUserRepository.save(payload);
    }
    public List<ApplicationUser> saveAll(List<ApplicationUser> payload){
        payload = payload.stream().filter(element -> element.getId()==null).collect(Collectors.toList());
        return applicationUserRepository.saveAll(payload);
    }

    public ApplicationUser update(ApplicationUser payload) throws ApiNotAcceptableException {
        if(payload.getId() == null)
            throw new ApiNotAcceptableException("id must not be null for update operation");

        ApplicationUser savedItem = findById(payload.getId());
        Utility.copyNonNullProperties(payload, savedItem);

        return applicationUserRepository.save(savedItem);
    }

    public List<ApplicationUser> findAll(){
        return applicationUserRepository.findAll();
    }
    public ApplicationUser findById(Long id) throws ApiNotAcceptableException {
        return applicationUserRepository.findById(id).orElseThrow(()-> new ApiNotAcceptableException("User was not found with id: " + id));
    }

    public void delete(Long id) throws ApiNotAcceptableException {
        ApplicationUser savedItem = findById(id);
        applicationUserRepository.delete(savedItem);
    }


}
