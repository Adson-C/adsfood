package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cardapio")
//@Builder
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Cardapio {

    // Atributos
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Boolean disponivel;
    private BigDecimal valor;
    @ManyToOne
    private Categoria categoria;
    @Column(name = "data_de_registro")
    private LocalDateTime dataRegistro = LocalDateTime.now();

// Construtores
    public Cardapio() {
    }

    public Cardapio(String nome, String descricao, Boolean disponivel, BigDecimal valor, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.disponivel = disponivel;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @Override
    public String toString() {
        return "Cardapio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", disponivel=" + disponivel +
                ", valor=" + valor +
                ", categoria=" + categoria +
                ", dataRegistro=" + dataRegistro +
                '}';
    }
}
