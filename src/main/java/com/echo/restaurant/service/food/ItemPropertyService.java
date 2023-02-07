package com.echo.restaurant.service.food;

import com.echo.restaurant.entity.auth.ApplicationUserRole;
import com.echo.restaurant.entity.food.ItemProperty;
import com.echo.restaurant.exception.ApiNotAcceptableException;
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
public class ItemPropertyService {
    private final ItemPropertyRepository itemPropertyRepository;

    public ItemProperty save(ItemProperty item) throws ApiNotAcceptableException {
        if(item.getId()!=null)
            throw new ApiNotAcceptableException("id field must be null for save operation");
        return itemPropertyRepository.save(item);
    }

    public List<ItemProperty> saveAll(List<ItemProperty> itemList){
        itemList = itemList.stream().filter(element -> element.getId()==null).collect(Collectors.toList());
        return itemPropertyRepository.saveAll(itemList);
    }

    public ItemProperty update(ItemProperty item) throws ApiNotAcceptableException {
        if(item.getId() == null)
            throw new ApiNotAcceptableException("id must not be null for update operation");

        ItemProperty savedItem = findById(item.getId());
        Utility.copyNonNullProperties(item, savedItem);

        return itemPropertyRepository.save(savedItem);
    }

    public List<ItemProperty> findAll(){
        return itemPropertyRepository.findAll();
    }
    public ItemProperty findById(Long id) throws ApiNotAcceptableException {
        return itemPropertyRepository.findById(id).orElseThrow(()-> new ApiNotAcceptableException("ItemProperty was not found with id: " + id));
    }

    public void delete(Long id) throws ApiNotAcceptableException {
        ItemProperty savedItem = findById(id);
        itemPropertyRepository.delete(savedItem);
    }


}
