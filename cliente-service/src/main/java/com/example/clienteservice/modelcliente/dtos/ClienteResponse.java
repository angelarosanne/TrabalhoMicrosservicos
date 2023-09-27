package com.example.clienteservice.modelcliente.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class ClienteResponse {
    private long id;
    private String nome;
    private String cpf;
}
