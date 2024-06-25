package com.ludovic.altenshop.repository;

import com.ludovic.altenshop.entities.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produits, Long> {

}
