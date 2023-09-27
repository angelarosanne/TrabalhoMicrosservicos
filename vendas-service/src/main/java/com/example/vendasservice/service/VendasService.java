package com.example.vendasservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.vendasservice.modelvendas.Vendas;
import com.example.vendasservice.modelvendas.dto.BaseResponse;
import com.example.vendasservice.modelvendas.dto.VendasRequest;
import com.example.vendasservice.repository.VendasReposiroty;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
public class VendasService {

    private final VendasReposiroty vendasRepository;
    private final WebClient.Builder webClientBuilder;
    
    public void addVendas(VendasRequest vendasRequest){

        // verificar estoque

        boolean resultado = this.webClientBuilder.build()
                    .post()
                    .uri("lb://estoque-service/api/estoque/" + vendasRequest.getCodigoDeBarras())
                    .bodyValue(vendasRequest.getCodigoDeBarras())
                    .retrieve()
                    .bodyToMono(boolean.class)
                    .block();


        boolean resultado2 = this.webClientBuilder.build()
                .post()
                .uri("lb://cliente-service/api/cliente/" + vendasRequest.getCpf())
                .bodyValue(vendasRequest.getCpf())
                .retrieve()
                .bodyToMono(boolean.class)
                .block();

        if(resultado != false && resultado2 != false){
            var vendas = Vendas.builder()
            .codigoDeBarras(vendasRequest.getCodigoDeBarras())
            .cpf(vendasRequest.getCpf())
            .quantidade(vendasRequest.getQuantidade())
            .build();
            
            this.vendasRepository.save(vendas);
        }else{
            throw new IllegalArgumentException("Erro na compra, não tem produto ou cliente não cadastrado");
        }

        
        
    }





}
