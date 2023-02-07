package com.echo.restaurant.entity.order;

import com.echo.restaurant.entity.auth.ApplicationUser;
import com.echo.restaurant.entity.food.Item;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "")
@Entity
@Builder
@Table(name = "order_items")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(scope = ApplicationUser.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class OrderItemDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;     // customer instructions from customers, things like toppings etc

    private Integer quantity;

    private Double price;

    private String productName;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Order order;
}
