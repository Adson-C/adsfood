package org.example.dao;

import org.example.entity.Ordem;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class OrdemDao {
    // entity manager
    private EntityManager entityManager;
    // construtor
    public OrdemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    // CRUD - Create, Read, Update, Delete
    // persistir  create cadastro
    public void cadastrar(final Ordem ordem) {
        this.entityManager.persist(ordem);
    }
    // buscar read
    public Ordem buscarPorId(final Integer id) {
        return this.entityManager.find(Ordem.class, id);
    }
    public List<Ordem> consultarTodos() {
        try {
            String jpql = "SELECT o FROM Ordem o";
            return this.entityManager.createQuery(jpql, Ordem.class).getResultList();

        }catch (Exception e){
            return Collections.emptyList();
        }
    }
    // atualizar update
    public void atualizar(final Ordem ordem) {
        this.entityManager.merge(ordem);
    }
    // deletar delete
    public void excluir(final Ordem ordem) {
        this.entityManager.remove(ordem);
    }
}
