package com.shivam.Ecom.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class itemModel {
    int id;
    String name;
    String description;
    int rating ;
    int quantity;
    boolean inStock;
    String brand;
    String category;

}
