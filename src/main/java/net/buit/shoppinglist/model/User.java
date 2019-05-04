package net.buit.shoppinglist.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Column(nullable = false)
    @Getter @Setter
    private String name;

    @Email
    @Column(nullable = false)
    @Getter @Setter
    private String email;

    @Getter @Setter
    private String imageUrl;

    @Column(nullable = false)
    @Getter @Setter
    private Boolean emailVerified = false;

    @JsonIgnore
    @Getter @Setter
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private AuthProvider provider;

    @Getter @Setter
    private String providerId;
}
