package com.example.estoqueservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.estoqueservice.model.dto.EstoqueRequest;
import com.example.estoqueservice.service.EstoqueService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/estoque")
@RequiredArgsConstructor
public class EstoqueController {

    private final EstoqueService estoqueService;
    

    @PostMapping("/{codigoDeBarras}")
    @ResponseStatus(HttpStatus.OK)
    public boolean temNoEstoque(@PathVariable("codigoDeBarras") Long codigoDeBarras){
        return estoqueService.temNoEstoque(codigoDeBarras);
    }

    
}
