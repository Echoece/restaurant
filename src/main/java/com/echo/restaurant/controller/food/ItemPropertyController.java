package com.echo.restaurant.controller.food;

import com.echo.restaurant.entity.food.ItemProperty;
import com.echo.restaurant.exception.ApiNotAcceptableException;
import com.echo.restaurant.service.food.ItemPropertyService;
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
@RequestMapping("api/v1/item-property")
@RequiredArgsConstructor
public class ItemPropertyController {
    private final ItemPropertyService itemPropertyService;

    @GetMapping
    public List<ItemProperty> getAll (){
        return itemPropertyService.findAll();
    }

    @GetMapping("/{id}")
    public ItemProperty getById(@PathVariable Long id) throws ApiNotAcceptableException {
        return itemPropertyService.findById(id);
    }

    @PatchMapping
    public ItemProperty partialUpdate(@RequestBody ItemProperty payload) throws ApiNotAcceptableException {
        return itemPropertyService.update(payload);
    }

    @DeleteMapping
    public void delete(Long id) throws ApiNotAcceptableException {
        itemPropertyService.delete(id);
    }

    @PostMapping
    public ItemProperty create(@RequestBody ItemProperty payload) throws ApiNotAcceptableException {
        return itemPropertyService.save(payload);
    }

    @PostMapping("/save-all")
    public List<ItemProperty> createAll(@RequestBody List<ItemProperty> payload){
        return itemPropertyService.saveAll(payload);
    }

}
