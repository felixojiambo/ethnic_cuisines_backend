package com.ecom.recipesharing.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String title;
    @ManyToOne
    private  User user;
    private  String image;
    private  String description;
    private boolean bagitarian;
    private LocalDateTime createdAt;
    private List<Long> likes=new ArrayList<>();
}
