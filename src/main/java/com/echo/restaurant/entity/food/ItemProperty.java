package com.echo.restaurant.entity.food;

import com.echo.restaurant.entity.auth.ApplicationUser;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "")
@Entity
@Builder
@Table(name = "item_properties")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(scope = ApplicationUser.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ItemProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    @ManyToOne
    private Item item;
}
