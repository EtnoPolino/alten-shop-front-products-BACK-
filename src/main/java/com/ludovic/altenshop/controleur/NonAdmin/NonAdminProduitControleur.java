package com.ludovic.altenshop.controleur.NonAdmin;

import com.ludovic.altenshop.service.serviceInterface.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class NonAdminProduitControleur {
    
    private final ProduitService produitService;

    @GetMapping
    public ResponseEntity<?> ObtenirTousLesProduits(){
        return ResponseEntity.ok(produitService.obtenirTousLesProduits());
    }

}
