package com.example.vendasservice.modelvendas;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "vendas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vendas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private Long codigoDeBarras;
    private Long quantidade;


}
