package org.example.dao;

import org.example.entity.Categoria;
import org.example.entity.Endereco;
import org.example.entity.Ordem;
import org.example.vo.ClienteVo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class EnderecoDao {
    // entity manager
    private EntityManager entityManager;

    public EnderecoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Endereco endereco) {
        this.entityManager.persist(endereco);
    }

    public Categoria consultarPorId(final Integer id) {
        return this.entityManager.find(Categoria.class, id);
    }

    public List<Endereco> consultarTodos() {
        String jpql = "SELECT e FROM Endereco e";
        return this.entityManager.createQuery(jpql,Endereco.class).getResultList();
    }

    public List<ClienteVo> consultarClientes(final String estado,final String cidade,final String rua) {
        String jpql = "SELECT new org.example.vo.ClienteVo(e.cliente.cpf, e.cliente.nome) " +
                "FROM Endereco e WHERE 1=1";
        if (Objects.nonNull(estado) && Objects.nonNull(cidade) && Objects.nonNull(rua)) {
            jpql = jpql.concat("AND UPPER(e.estado) = UPPER(:estado) AND " +
                    "UPPER(e.cidade) = UPPER(:cidade) AND " +
                    "UPPER(e.rua) = UPPER(:rua)");
        }
        TypedQuery typedQuery = this.entityManager.createQuery(jpql,ClienteVo.class);
        if (Objects.nonNull(estado) && Objects.nonNull(cidade) && Objects.nonNull(rua)) {
            typedQuery.setParameter("estado", estado);
            typedQuery.setParameter("cidade", cidade);
            typedQuery.setParameter("rua", rua);
        }
        return typedQuery.getResultList();
    }

    public void atualizar(final Endereco endereco){
        this.entityManager.merge(endereco);
    }

    public void excluir(final Endereco endereco){
        this.entityManager.remove(endereco);
    }
}
