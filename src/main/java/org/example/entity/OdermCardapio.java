package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "ordens_cardapio")
//@Builder
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class OdermCardapio {

    @Id
    private Integer id;

    @ManyToOne
    private Ordem ordem;
    @ManyToOne
    private Cardapio cardapio;
    private BigDecimal valor;
    private Integer quantidade;

    public OdermCardapio(Ordem ordem, Cardapio buscarPorId, int i) {

    }

    @Override
    public String toString() {
        return "OrdemCardapio{" +
                "id=" + id +
                ", ordem=" + ordem +
                ", cardapio=" + cardapio +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}
