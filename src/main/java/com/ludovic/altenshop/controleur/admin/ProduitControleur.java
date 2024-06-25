package com.ludovic.altenshop.controleur.admin;

import com.ludovic.altenshop.dto.ProduitDto;
import com.ludovic.altenshop.service.serviceInterface.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProduitControleur {

    private final ProduitService produitService;


    @GetMapping
    public ResponseEntity<?> ObtenirTousLesProduits(){
        return ResponseEntity.ok(produitService.obtenirTousLesProduits());
    }

    @PostMapping("/produit")
    public ResponseEntity<ProduitDto> creerUnProduit(@RequestBody ProduitDto produitDto){
        ProduitDto produitCree = produitService.creerUnProduit(produitDto);

        if(produitCree == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(produitCree);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnProduit(@PathVariable Long id){
        produitService.deleteProduit(id);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/produits/{ids}")
    public ResponseEntity<Void> effacerPlusieursId(@PathVariable Long[] ids){
        produitService.deletePlusieursIds(ids);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitDto> chercheUnProduitParId(@PathVariable Long id){
        return ResponseEntity.ok(produitService.getProduitById(id));
    }

    @PutMapping("/produit/{id}")
    public ResponseEntity<ProduitDto> updateProduit(@PathVariable Long id, @RequestBody ProduitDto produitDto){
        ProduitDto updatedTask = produitService.updateProduit(id, produitDto);
        if(updatedTask == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedTask);
    }


}
