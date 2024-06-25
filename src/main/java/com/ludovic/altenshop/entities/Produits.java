package com.ludovic.altenshop.entities;

import com.ludovic.altenshop.dto.ProduitDto;
import com.ludovic.altenshop.enums.Categories;
import com.ludovic.altenshop.enums.StatutProduit;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq", initialValue = 1000)
public class Produits {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;
    private String code;
    private String name;
    private String description;
    private Categories category;
    private StatutProduit inventoryStatus;
    private int quantity;
    private int price;
    private int rating;

    public ProduitDto getProduitDto(){
        ProduitDto produitDto = new ProduitDto();

        produitDto.setId(id);
        produitDto.setCode(code);
        produitDto.setName(name);
        produitDto.setDescription(description);
        produitDto.setCategory(category);
        produitDto.setInventoryStatus(inventoryStatus);
        produitDto.setQuantity(quantity);
        produitDto.setPrice(price);
        produitDto.setRating(rating);

        return produitDto;
    }
}
