package com.echo.restaurant.entity.order;

import com.echo.restaurant.entity.auth.Address;
import com.echo.restaurant.entity.auth.ApplicationUser;
import com.echo.restaurant.enums.OrderStatus;
import com.echo.restaurant.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "")
@Entity
@Builder
@Table(name = "orders")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(scope = ApplicationUser.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderTime;

    private LocalDateTime preparedTime;

    private LocalDateTime deliveryStartTime;

    private LocalDateTime deliveryEndTime;

    private Double totalPrice;

    private Double deliveryFee;

    private Float taxRate;

    private Double totalPriceWithTax;

    private Boolean isPaid = Boolean.FALSE;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne
    private ApplicationUser customer;

    @ManyToOne
    private ApplicationUser deliveryMan;

    @ManyToOne
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<OrderItemDetail> itemDetails = new ArrayList<>();

}
