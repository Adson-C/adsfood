package org.example.service.teste;

import org.example.dao.CardapioDao;
import org.example.entity.Cardapio;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        // teste com Class Prato
        Cardapio feijoada = new Cardapio();
        feijoada.setNome("Feijoada");
        feijoada.setDescricao("Feijoada completa");
        feijoada.setDisponivel(true);
        feijoada.setValor(BigDecimal.valueOf(30.00));

        Cardapio salmao = new Cardapio();
        salmao.setNome("salmao");
        salmao.setDescricao("Salmao ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(70.00));

        // persistir no banco de dados
        EntityManager entityManager = JPAUtil.getEntityManagerAdsFood();

        // PratoDao
        CardapioDao pratoDao = new CardapioDao(entityManager);
        // iniciar transação
        entityManager.getTransaction().begin();
        // persistir
        pratoDao.cadastrar(feijoada);
        entityManager.flush();
        pratoDao.cadastrar(salmao);
        entityManager.flush();
        System.out.println("O Prato consultado foi :" + pratoDao.buscarPorId(2));

        pratoDao.deletar(salmao);
        System.out.println("O Prato consultado foi :" + pratoDao.buscarPorId(2));
        // commit
//        entityManager.getTransaction().commit();
        entityManager.clear();
        // fechar
//        entityManager.close();
        feijoada.setValor(BigDecimal.valueOf(50.00));
        pratoDao.atualizar(feijoada);
        System.out.println("O Prato consultado foi :" + pratoDao.buscarPorId(1));

    }
}
