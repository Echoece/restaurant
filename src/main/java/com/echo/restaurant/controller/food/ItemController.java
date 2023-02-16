package com.echo.restaurant.controller.food;

import com.echo.restaurant.entity.food.Item;
import com.echo.restaurant.exception.ApiNotAcceptableException;
import com.echo.restaurant.service.food.ItemService;
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
@RequestMapping("api/v1/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping
    public List<Item> getAll (){
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Item getById(@PathVariable Long id) throws ApiNotAcceptableException {
        return itemService.findById(id);
    }

    @PatchMapping
    public Item partialUpdate(@RequestBody Item payload) throws ApiNotAcceptableException {
        return itemService.update(payload);
    }

    @DeleteMapping
    public void delete(Long id) throws ApiNotAcceptableException {
        itemService.delete(id);
    }

    @PostMapping
    public Item create(@RequestBody Item payload) throws ApiNotAcceptableException {
        return itemService.save(payload);
    }

    @PostMapping("/save-all")
    public List<Item> createAll(@RequestBody List<Item> payload){
        return itemService.saveAll(payload);
    }

}
