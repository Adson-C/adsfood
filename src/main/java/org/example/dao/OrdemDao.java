package org.example.dao;

import org.example.entity.Ordem;
import org.example.vo.ItensPrincipaisVo;

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
    // consultar itens mais vendidos
    public List<ItensPrincipaisVo> consultarItensMaisVendidos() {
        try {
            // join entre ordem e ordens_cardapio
            String jpql = "SELECT new org.example.vo.ItensPrincipaisVo(" +
                    "c.nome, SUM(oc.quantidade)) FROM Ordem o " +
                    "JOIN OrdensCardapio oc on o.id = oc.cardapio.id " +
                    "JOIN oc.cardapio c " +
                    "GROUP BY c.nome " +
                    "ORDER BY SUM(oc.quantidade) DESC";
            return this.entityManager.createQuery(jpql, ItensPrincipaisVo.class).getResultList();

        }catch (Exception e){
            return Collections.emptyList();
        }
    }
    public Ordem joinFetchCliente(final Integer id) {
            String jpql = "SELECT o FROM Ordem o JOIN FECH o.cliente WHERE o.id = :id";
            return this.entityManager.createQuery(jpql, Ordem.class).setParameter("id", id).getSingleResult();

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
