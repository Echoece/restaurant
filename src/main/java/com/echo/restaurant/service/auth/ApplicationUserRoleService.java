package com.echo.restaurant.service.auth;

import com.echo.restaurant.entity.auth.ApplicationUserRole;
import com.echo.restaurant.entity.food.ItemProperty;
import com.echo.restaurant.exception.ApiNotAcceptableException;
import com.echo.restaurant.repository.auth.ApplicationUserRoleRepository;
import com.echo.restaurant.repository.food.ItemPropertyRepository;
import com.echo.restaurant.utility.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationUserRoleService {
    private final ApplicationUserRoleRepository applicationUserRoleRepository;

    public ApplicationUserRole save(ApplicationUserRole item) throws ApiNotAcceptableException {
        if(item.getId()!=null)
            throw new ApiNotAcceptableException("id field must be null for save operation");
        return applicationUserRoleRepository.save(item);
    }

    public List<ApplicationUserRole> saveAll(List<ApplicationUserRole> itemList){
        itemList = itemList.stream().filter(element -> element.getId()==null).collect(Collectors.toList());
        return applicationUserRoleRepository.saveAll(itemList);
    }

    public ApplicationUserRole update(ApplicationUserRole item) throws ApiNotAcceptableException {
        if(item.getId() == null)
            throw new ApiNotAcceptableException("id must not be null for update operation");

        ApplicationUserRole savedItem = findById(item.getId());
        Utility.copyNonNullProperties(item, savedItem);

        return applicationUserRoleRepository.save(savedItem);
    }

    public List<ApplicationUserRole> findAll(){
        return applicationUserRoleRepository.findAll();
    }
    public ApplicationUserRole findById(Long id) throws ApiNotAcceptableException {
        return applicationUserRoleRepository.findById(id).orElseThrow(()-> new ApiNotAcceptableException("Role was not found with id: " + id));
    }

    public void delete(Long id) throws ApiNotAcceptableException {
        ApplicationUserRole savedItem = findById(id);
        applicationUserRoleRepository.delete(savedItem);
    }


}
