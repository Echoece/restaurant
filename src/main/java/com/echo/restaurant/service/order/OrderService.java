package com.echo.restaurant.service.order;

import com.echo.restaurant.entity.order.Order;
import com.echo.restaurant.enums.OrderStatus;
import com.echo.restaurant.exception.ApiNotAcceptableException;
import com.echo.restaurant.repository.order.OrderRepository;
import com.echo.restaurant.utility.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order save(Order item) throws ApiNotAcceptableException {
        if(item.getId()!=null)
            throw new ApiNotAcceptableException("id field must be null for save operation");
        return orderRepository.save(item);
    }

    public List<Order> saveAll(List<Order> itemList){
        itemList = itemList.stream().filter(element -> element.getId()==null).collect(Collectors.toList());
        return orderRepository.saveAll(itemList);
    }

    public Order update(Order item) throws ApiNotAcceptableException {
        if(item.getId() == null)
            throw new ApiNotAcceptableException("id must not be null for update operation");

        Order savedItem = findById(item.getId());
        Utility.copyNonNullProperties(item, savedItem);

        return orderRepository.save(savedItem);
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
    public Order findById(Long id) throws ApiNotAcceptableException {
        return orderRepository.findById(id).orElseThrow(()-> new ApiNotAcceptableException("Order was not found with id: " + id));
    }

    public void delete(Long id) throws ApiNotAcceptableException {
        Order savedItem = findById(id);
        orderRepository.delete(savedItem);
    }

    public List<Order> filterOrderByOrderStatus(OrderStatus orderStatus){
        return orderRepository.findAllByStatus(orderStatus);
    }
}
