package com.example.estoqueservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.estoqueservice.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    
    Optional<Estoque> findByCodigoDeBarras(Long cpf);
}
