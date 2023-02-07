package com.echo.restaurant.repository.order;

import com.echo.restaurant.entity.order.Order;
import com.echo.restaurant.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByStatus(OrderStatus orderStatus);
}
