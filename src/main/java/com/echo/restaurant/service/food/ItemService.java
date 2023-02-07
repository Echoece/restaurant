package com.echo.restaurant.service.food;

import com.echo.restaurant.entity.food.Item;
import com.echo.restaurant.exception.ApiNotAcceptableException;
import com.echo.restaurant.repository.food.ItemRepository;
import com.echo.restaurant.utility.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Item save(Item item) throws ApiNotAcceptableException {
        if(item.getId()!=null)
            throw new ApiNotAcceptableException("id field must be null to save item entity");
        return itemRepository.save(item);
    }

    public List<Item> saveAll(List<Item> itemList){
        itemList = itemList.stream().filter(element -> element.getId()==null).collect(Collectors.toList());
        return itemRepository.saveAll(itemList);
    }

    public Item update(Item item) throws ApiNotAcceptableException {
        if(item.getId() == null)
            throw new ApiNotAcceptableException("id must not be null for update operation");

        Item savedItem = findById(item.getId());
        Utility.copyNonNullProperties(item, savedItem);

        return itemRepository.save(savedItem);
    }

    public List<Item> findAll(){
        return itemRepository.findAll();
    }
    public Item findById(Long id) throws ApiNotAcceptableException {
        return itemRepository.findById(id).orElseThrow(()-> new ApiNotAcceptableException("Item was not found with id: " + id));
    }

    public void delete(Long id) throws ApiNotAcceptableException {
        Item savedItem = findById(id);
        itemRepository.delete(savedItem);
    }

    public Item toggleItemVegeterian(Long id) throws ApiNotAcceptableException {
        Item item = findById(id);
        item.setIsVegetarian(!item.getIsVegetarian());
        return itemRepository.save(item);
    }


}
