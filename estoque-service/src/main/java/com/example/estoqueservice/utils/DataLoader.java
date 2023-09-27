package com.example.estoqueservice.utils;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.estoqueservice.model.Estoque;
import com.example.estoqueservice.repository.EstoqueRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {
    
    private final EstoqueRepository estoqueRepository;



    @Override
    public void run(String... args) throws Exception {
    log.info("Carregando arquivos...");
    if (estoqueRepository.findAll().size()==0) {
        estoqueRepository.saveAll(
            List.of(Estoque.builder().codigoDeBarras(000001L).quantidade(1L).build(),
            Estoque.builder().codigoDeBarras(000002L).quantidade(2L).build(),
            Estoque.builder().codigoDeBarras(000003L).quantidade(3L).build(),
            Estoque.builder().codigoDeBarras(000004L).quantidade(4L).build(),
            Estoque.builder().codigoDeBarras(000005L).quantidade(0L).build()
        ));
    }
    log.info("Carregamento concluído.");
}

}
