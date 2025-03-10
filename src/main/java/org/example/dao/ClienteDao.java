package org.example.dao;

import org.example.entity.Cliente;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public class ClienteDao {
    // entity manager
    private EntityManager entityManager;
    // construtor
    public ClienteDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    // CRUD - Create, Read, Update, Delete
    // persistir  create cadastro
    public void cadastrar(final Cliente cliente) {
        this.entityManager.persist(cliente);
    }
    // buscar read
    public Cliente buscarPorId(final Integer id) {
        return this.entityManager.find(Cliente.class, id);
    }
    public List<Cliente> consultarTodos() {
        try {
            String jpql = "SELECT c FROM Cliente c";
            return this.entityManager.createQuery(jpql, Cliente.class).getResultList();

        }catch (Exception e){
            return Collections.emptyList();
        }
    }

    // consultar por LIKE
    public List<Cliente> consultarPorNome(final String nome) {
        try {
            String jpql = "SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(:nome)";
            return this.entityManager.createQuery(jpql, Cliente.class)
                    .setParameter("nome", nome + "%")
                    .getResultList();

        }catch (Exception e){
            return Collections.emptyList();
        }
    }

    // atualizar update
    public void atualizar(final Cliente cliente) {
        this.entityManager.merge(cliente);
    }
    // deletar delete
    public void excluir(final Cliente cliente) {
        this.entityManager.remove(cliente);
    }
}
