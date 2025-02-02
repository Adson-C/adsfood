package org.example.dao;

import org.example.entity.Cardapio;

import javax.persistence.EntityManager;

public class CardapioDao {
    // entity manager
    private EntityManager entityManager;
    // construtor
    public CardapioDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    // CRUD - Create, Read, Update, Delete
    // persistir  create cadastro
    public void cadastrar(final Cardapio prato) {
        this.entityManager.persist(prato);
    }
    // buscar read
    public Cardapio buscarPorId(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }
    // atualizar update
    public void atualizar(final Cardapio prato) {
        this.entityManager.merge(prato);
    }
    // deletar delete
    public void deletar(final Cardapio prato) {
        this.entityManager.remove(prato);
    }
}
