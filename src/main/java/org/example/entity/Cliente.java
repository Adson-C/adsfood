package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private String nome;
    @Id
    private String cpf;
    private String cep;

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
