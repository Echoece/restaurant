package com.echo.restaurant.controller.auth;

import com.echo.restaurant.entity.auth.ApplicationUser;
import com.echo.restaurant.exception.ApiNotAcceptableException;
import com.echo.restaurant.service.auth.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class ApplicationUserController {
    private final ApplicationUserService userService;

    @GetMapping
    public List<ApplicationUser> getAll (){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ApplicationUser getById(@PathVariable Long id) throws ApiNotAcceptableException {
        return userService.findById(id);
    }

    @PatchMapping
    public ApplicationUser partialUpdate(@RequestBody ApplicationUser payload) throws ApiNotAcceptableException {
        return userService.update(payload);
    }

    @DeleteMapping
    public void delete(Long id) throws ApiNotAcceptableException {
        userService.delete(id);
    }

    @PostMapping
    public ApplicationUser create(@RequestBody ApplicationUser payload) throws ApiNotAcceptableException {
        return userService.save(payload);
    }

    @PostMapping("/admin")
    public ApplicationUser createAdmin(@RequestBody ApplicationUser payload) throws ApiNotAcceptableException {
        return userService.save(payload);
    }

    @PostMapping("/deliveryman")
    public ApplicationUser createDeliveryMan(@RequestBody ApplicationUser payload) throws ApiNotAcceptableException {
        return userService.save(payload);
    }

    @PostMapping("/save-all")
    public List<ApplicationUser> createAll(@RequestBody List<ApplicationUser> payload){
        return userService.saveAll(payload);
    }

}
