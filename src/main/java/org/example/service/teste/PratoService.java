package org.example.service.teste;

import org.example.entity.Prato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class PratoService {
    public static void main(String[] args) {
        // teste com Class Prato
        Prato feijoada = new Prato();
        feijoada.setNome("Feijoada");
        feijoada.setDescricao("Feijoada completa");
        feijoada.setDisponivel(true);
        feijoada.setValor(BigDecimal.valueOf(30.0));
        // persistir no banco de dados
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("adsFood");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // iniciar transação
        entityManager.getTransaction().begin();
        // persistir
        entityManager.persist(feijoada);
        // commit
        entityManager.getTransaction().commit();
        // fechar
        entityManager.close();

    }
}
