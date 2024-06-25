package com.ludovic.altenshop.dto;

import com.ludovic.altenshop.enums.Categories;
import com.ludovic.altenshop.enums.StatutProduit;
import lombok.Data;

@Data
public class ProduitDto {

    private Long id;
    private String code;
    private String name;
    private String description;
    private Categories category;
    private StatutProduit inventoryStatus;
    private int quantity;
    private int price;
    private int rating;

}
