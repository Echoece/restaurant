package com.echo.restaurant.controller.auth;

import com.echo.restaurant.entity.auth.ApplicationUserRole;
import com.echo.restaurant.exception.ApiNotAcceptableException;
import com.echo.restaurant.service.auth.ApplicationUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("api/v1/role")
@RequiredArgsConstructor
public class ApplicationUserRoleController {
    private final ApplicationUserRoleService roleService;

    @GetMapping
    public List<ApplicationUserRole> getAll (){
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public ApplicationUserRole getById(@PathVariable Long id) throws ApiNotAcceptableException {
        return roleService.findById(id);
    }

    @PatchMapping
    public ApplicationUserRole partialUpdate(@RequestBody ApplicationUserRole payload) throws ApiNotAcceptableException {
        return roleService.update(payload);
    }

    @DeleteMapping
    public void delete(Long id) throws ApiNotAcceptableException {
        roleService.delete(id);
    }

    @PostMapping
    public ApplicationUserRole create(@RequestBody ApplicationUserRole payload) throws ApiNotAcceptableException {
        return roleService.save(payload);
    }

    @PostMapping("/save-all")
    public List<ApplicationUserRole> createAll(@RequestBody List<ApplicationUserRole> payload){
        return roleService.saveAll(payload);
    }

}
