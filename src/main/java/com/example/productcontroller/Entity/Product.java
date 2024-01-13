package com.example.productcontroller.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Short amount; //кол-во


    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name =  "category_id")
    private Category category;


}
