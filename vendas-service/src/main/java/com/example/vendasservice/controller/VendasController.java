package com.example.vendasservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.vendasservice.modelvendas.dto.VendasRequest;
import com.example.vendasservice.service.VendasService;


@RestController
@RequestMapping("/api/vendas")
@RequiredArgsConstructor
public class VendasController {


    private final VendasService vendasService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String adicionarVendas(@RequestBody VendasRequest vendasRequest){
        this.vendasService.addVendas(vendasRequest);
        return "Venda realizada com sucesso";
    }
    
}
