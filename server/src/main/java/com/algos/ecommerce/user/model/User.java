package com.algos.ecommerce.user.model;

import com.algos.ecommerce.product.model.Image;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @NotBlank @Size(max = 50) @Email
    private String email;

    @NotBlank @Size(max = 120) @JsonIgnore
    private String password;

    @OneToOne
    @JoinColumn(name = "userDetails_id", referencedColumnName = "userDetailsID")
    private UserDetails userDetails;

}