package org.example.dao;

import org.example.entity.Categoria;
import org.example.entity.Endereco;
import org.example.entity.Ordem;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

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

    public void atualizar(final Endereco endereco){
        this.entityManager.merge(endereco);
    }

    public void excluir(final Endereco endereco){
        this.entityManager.remove(endereco);
    }
}
