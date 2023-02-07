package com.echo.restaurant.controller.Order;

import com.echo.restaurant.entity.order.Order;
import com.echo.restaurant.enums.OrderStatus;
import com.echo.restaurant.exception.ApiNotAcceptableException;
import com.echo.restaurant.service.order.OrderService;
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
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<Order> getAll (){
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) throws ApiNotAcceptableException {
        return orderService.findById(id);
    }

    @PatchMapping
    public Order partialUpdate(@RequestBody Order payload) throws ApiNotAcceptableException {
        return orderService.update(payload);
    }

    @DeleteMapping
    public void delete(Long id) throws ApiNotAcceptableException {
        orderService.delete(id);
    }

    @PostMapping
    public Order create(@RequestBody Order payload) throws ApiNotAcceptableException {
        return orderService.save(payload);
    }

    @PostMapping("/save-all")
    public List<Order> createAll(@RequestBody List<Order> payload){
        return orderService.saveAll(payload);
    }

    @GetMapping("/filter-by-status")
    public List<Order>  filterOrderByOrderStatus(@RequestBody OrderStatus orderStatus){
        return orderService.filterOrderByOrderStatus(orderStatus);
    }

}
