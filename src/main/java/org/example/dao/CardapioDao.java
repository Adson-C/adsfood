package org.example.dao;

import org.example.entity.Cardapio;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

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

    public List<Cardapio> consultarPorValor(final BigDecimal filtro){
        try {

        String jpql = "SELECT c FROM Cardapio c WHERE c.valor = :valor";
        return this.entityManager.createQuery(jpql,Cardapio.class).setParameter("valor",filtro).getResultList();
        }catch (Exception e){
            return Collections.emptyList();
        }
    }
    // consulta por nome
    public Cardapio consultarPorNome(final String filtro){
        try {
            String jpql = "SELECT c FROM Cardapio c WHERE UPPER(c.nome) = UPPER(:nome)";
            return this.entityManager.createQuery(jpql,Cardapio.class).setParameter("nome",filtro).getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    // buscar read
    public Cardapio buscarPorId(final Integer id) {
        return this.entityManager.find(Cardapio.class, id);
    }
    // listar read
    public List<Cardapio> consultarTodos() {
        // JPql - Java Persistence Query Language
        try {
            String sql = "SELECT p FROM Cardapio p";
            return this.entityManager.createQuery(sql, Cardapio.class).getResultList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
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
