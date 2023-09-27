package com.example.estoqueservice.service;

import org.springframework.stereotype.Service;

import com.example.estoqueservice.model.Estoque;
import com.example.estoqueservice.model.dto.EstoqueRequest;
import com.example.estoqueservice.repository.EstoqueRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstoqueService {
    private final EstoqueRepository estoqueRepository;

    public boolean temNoEstoque(Long codigoDeBarras){
        var estoque = estoqueRepository.findByCodigoDeBarras(codigoDeBarras);

        return estoque.filter(value -> value.getQuantidade() > 0).isPresent();
    }


}
