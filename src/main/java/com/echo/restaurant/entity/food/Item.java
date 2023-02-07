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

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "")
@Entity
@Builder
@Table(name = "items")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(scope = ApplicationUser.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;   // if itemProperty exists, then price from itemProperty will be used instead of this.

    private Double priceWithDiscount;

    private String category;

    private Boolean isVegetarian;

    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ItemProperty> itemProperty = new HashSet<>();
}
