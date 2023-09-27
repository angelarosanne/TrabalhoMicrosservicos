package com.example.vendasservice.modelvendas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VendasRequest {
    private Long id;
    private String cpf;
    private Long codigoDeBarras;
    private Long quantidade;
}
