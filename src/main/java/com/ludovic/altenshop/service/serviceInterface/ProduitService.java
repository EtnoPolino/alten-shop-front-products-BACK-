package com.ludovic.altenshop.service.serviceInterface;

import com.ludovic.altenshop.dto.ProduitDto;

import java.util.List;

public interface ProduitService {

    ProduitDto creerUnProduit(ProduitDto produitDto);
    List<ProduitDto> obtenirTousLesProduits();

    void deleteProduit(Long id);

    void deletePlusieursIds(Long[] ids);

    ProduitDto updateProduit(Long id, ProduitDto taskDto);

    ProduitDto getProduitById(Long id);


}
