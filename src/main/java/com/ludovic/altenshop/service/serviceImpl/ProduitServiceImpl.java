package com.ludovic.altenshop.service.serviceImpl;

import com.ludovic.altenshop.dto.ProduitDto;
import com.ludovic.altenshop.entities.Produits;
import com.ludovic.altenshop.enums.Categories;
import com.ludovic.altenshop.enums.StatutProduit;
import com.ludovic.altenshop.repository.ProduitRepository;
import com.ludovic.altenshop.service.serviceInterface.ProduitService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;
    @Override
    public ProduitDto creerUnProduit(ProduitDto produitDto) {
        Produits produit = new Produits();

        produit.setCode(produitDto.getCode());
        produit.setName(produitDto.getName());
        produit.setDescription(produitDto.getDescription());
        produit.setCategory(Categories.valueOf(produitDto.getCategory().name()));
        produit.setInventoryStatus(StatutProduit.valueOf(produitDto.getInventoryStatus().name()));
        produit.setQuantity(produitDto.getQuantity());
        produit.setPrice(produitDto.getPrice());
        produit.setRating(produitDto.getRating());

        return produitRepository.save(produit).getProduitDto();
    }

    @Override
    public List<ProduitDto> obtenirTousLesProduits() {
        return produitRepository.findAll().stream()
                                          .map(Produits::getProduitDto)
                                          .collect(Collectors.toList());
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public void deletePlusieursIds(Long[] ids) {
        for(Long id : ids){
            produitRepository.deleteById(id);
        }
    }

    @Override
    public ProduitDto updateProduit(Long id, ProduitDto produitDto) {
        Optional<Produits> optionalProduit = produitRepository.findById(id);

        if(optionalProduit.isPresent()){
            Produits updatedProduit = optionalProduit.get();

            updatedProduit.setName(produitDto.getName());
            updatedProduit.setCode(produitDto.getCode());
            updatedProduit.setDescription(produitDto.getDescription());
            updatedProduit.setPrice(produitDto.getPrice());
            updatedProduit.setQuantity(produitDto.getQuantity());
            updatedProduit.setCategory(produitDto.getCategory());
            updatedProduit.setInventoryStatus(produitDto.getInventoryStatus());
            updatedProduit.setRating(produitDto.getRating());

            return produitRepository.save(updatedProduit).getProduitDto();

        }

        throw new EntityNotFoundException("produit not found");
    }

    @Override
    public ProduitDto getProduitById(Long id) {
        Optional<Produits> optionalProduit = produitRepository.findById(id);
        if(optionalProduit.isPresent()){
            return optionalProduit.map(Produits::getProduitDto)
                                  .orElse(null);
        }
        throw new EntityNotFoundException("produit not found");
    }
}
