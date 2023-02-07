package com.echo.restaurant.entity.auth;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "roles")
@Entity
@Builder
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(scope = ApplicationUser.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank(message = "email is mandatory")
    @Size(max = 50)
    @Column(unique = true)
    private String email;

    @Size(min = 6, max = 255, message = "Your password must be more than 8 characters.")
    @NotNull(message = "Password can not be null.")
    @NotEmpty(message = "Password can not be empty.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String token;

    @JsonFormat(pattern = "dd-MM-yyyy" , shape = JsonFormat.Shape.STRING)
    private Date tokenExpireTime;

    private String name;

    private Boolean isDeliveryMan;
    private Boolean isAvailable;

    @OneToOne
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id",
                    referencedColumnName = "id"
            )
    )
    private Set<ApplicationUserRole> roles = new HashSet<>();


    public Set<String> getPrefixedRoleNames(){
        return roles.stream().map(element -> "ROLE_" + element.getName()).collect(Collectors.toSet());
    }
}
