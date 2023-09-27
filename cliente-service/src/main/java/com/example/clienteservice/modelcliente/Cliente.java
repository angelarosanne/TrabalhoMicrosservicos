package com.example.clienteservice.modelcliente;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
