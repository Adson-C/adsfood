package org.example.dao;

import org.example.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class CategoriaDao {
    // entity manager
    private EntityManager entityManager;
    // construtor
    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    // CRUD - Create, Read, Update, Delete
    // persistir  create cadastro
    public void cadastrar(final Categoria categoria) {
        this.entityManager.persist(categoria);
    }
    // buscar read
    public Categoria buscarPorId(final Integer id) {
        return this.entityManager.find(Categoria.class, id);
    }
    public List<Categoria> consultarTodos() {
        try {
            String jpql = "SELECT c FROM Categoria c";
            return this.entityManager.createQuery(jpql, Categoria.class).getResultList();

        }catch (Exception e){
            return Collections.emptyList();
        }
    }
    // atualizar update
    public void atualizar(final Categoria categoria) {
        this.entityManager.merge(categoria);
    }
    // deletar delete
    public void excluir(final Categoria categoria) {
        this.entityManager.remove(categoria);
    }
}
