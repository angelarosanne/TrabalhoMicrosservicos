package com.example.clienteservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.clienteservice.modelcliente.Cliente;
import com.example.clienteservice.modelcliente.dtos.ClienteRequest;
import com.example.clienteservice.modelcliente.dtos.ClienteResponse;
import com.example.clienteservice.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public void addCliente(ClienteRequest clienteRequest){
        var cliente = Cliente.builder()
        .nome(clienteRequest.getNome())
        .cpf(clienteRequest.getCpf())
        .build();
        
        clienteRepository.save(cliente);
        
        log.info("cliente add: {}", cliente);
    }

    public List<ClienteResponse> getAllClientes(){
        var clientes = clienteRepository.findAll();

        return clientes.stream().map(this::mapToClienteResponse).toList();
    }

    private ClienteResponse mapToClienteResponse(Cliente cliente){
        return ClienteResponse.builder()
        .id(cliente.getId())
        .nome(cliente.getNome())
        .cpf(cliente.getCpf())
        .build();
    }

    public boolean temCliente(String cpf){
        var cliente = clienteRepository.findByCpf(cpf);

        return cliente.isPresent();
    }


}
