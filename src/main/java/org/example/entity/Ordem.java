package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordens")
//@Builder
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Ordem {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "valor_total")
    private BigDecimal valorTotal;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    @ManyToOne
    private Cliente cliente;

    //    @JoinTable(name = "ordem_cardapio", joinColumns = @JoinColumn(name = "ordens_id"), inverseJoinColumns = @JoinColumn(name = "cardapio_id"))
    @OneToMany(mappedBy = "ordem")
    private List<OdermCardapio> ordemCardapiosList = new ArrayList<>();


    public void addOrdemCardapio( OdermCardapio ordemCardapio) {
        ordemCardapio.setOrdem(this);
        this.ordemCardapiosList.add(ordemCardapio);
    }

    public Ordem(Cliente cliente) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.dataCriacao = dataCriacao;
        this.cliente = cliente;
        this.ordemCardapiosList = ordemCardapiosList;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dataCriacao=" + dataCriacao +
                ", cliente=" + cliente +
                '}';
    }
}
