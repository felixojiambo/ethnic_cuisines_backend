package com.ecom.recipesharing.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private  Long id;
    private String password;
    private String email;
    private  String fullName;
}
