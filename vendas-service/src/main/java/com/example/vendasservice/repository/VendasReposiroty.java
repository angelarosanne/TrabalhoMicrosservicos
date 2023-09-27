package com.example.vendasservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vendasservice.modelvendas.Vendas;

@Repository
public interface VendasReposiroty extends JpaRepository<Vendas, Long>{
    
}
