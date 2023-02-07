package com.echo.restaurant.repository.food;

import com.echo.restaurant.entity.food.ItemProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPropertyRepository extends JpaRepository<ItemProperty, Long> {
}
