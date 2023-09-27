package com.example.clienteservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.clienteservice.modelcliente.dtos.ClienteRequest;
import com.example.clienteservice.modelcliente.dtos.ClienteResponse;
import com.example.clienteservice.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
@RequiredArgsConstructor
public class ClienteController {

    
    private final ClienteService clienteService;
    

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addCliente(@RequestBody ClienteRequest clienteRequest){
//        this.clienteService.addCliente(clienteRequest);
//    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteResponse>getALLClientes(){
        return this.clienteService.getAllClientes();
    }


    @PostMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public boolean temCliente(@PathVariable("cpf") String cpf){
        return clienteService.temCliente(cpf);
    }







}
