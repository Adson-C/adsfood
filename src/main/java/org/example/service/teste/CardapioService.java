package org.example.service.teste;

import org.example.dao.CardapioDao;
import org.example.util.CargaDeDadosUtil;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
            EntityManager entityManager = JPAUtil.getEntityManagerAdsFood();
            entityManager.getTransaction().begin();
            CargaDeDadosUtil.cadastarCategorias(entityManager);
            CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
            CardapioDao cardapioDao = new CardapioDao(entityManager);
            System.out.println("Lista de produtos por valor: "+ cardapioDao.consultarPorValor(BigDecimal.valueOf(59.00)));
            entityManager.close();
        }
}
