package org.example.service.teste;

import org.example.dao.CardapioDao;
import org.example.dao.CategoriaDao;
import org.example.entity.Cardapio;
import org.example.entity.Categoria;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {
    public static void main(String[] args) {
        // persistir no banco de dados
        EntityManager entityManager = JPAUtil.getEntityManagerAdsFood();
        cadastrarProdutoCardapio(entityManager, cadastrarCategoria(entityManager));
    }
    // cadastrar categoria
    private static Categoria cadastrarCategoria(EntityManager entityManager) {
        // teste com Class Categoria
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        Categoria pratoPrincipal = new Categoria("Prato Principal");
        // iniciar transação
        entityManager.getTransaction().begin();
        // persistir
        categoriaDao.cadastrar(pratoPrincipal);
        // commit
        entityManager.getTransaction().commit();
        // fechar
        entityManager.clear();
        return pratoPrincipal;
    }
    private static void cadastrarProdutoCardapio(EntityManager entityManager, Categoria categoria) {
        // teste com Class Prato
        Cardapio feijoada = new Cardapio();
        feijoada.setNome("Feijoada");
        feijoada.setDescricao("Feijoada completa");
        feijoada.setDisponivel(true);
        feijoada.setCategoria(categoria);
        feijoada.setValor(BigDecimal.valueOf(30.00));

        Cardapio salmao = new Cardapio();
        salmao.setNome("salmao");
        salmao.setDescricao("Salmao ao molho de maracuja");
        salmao.setDisponivel(true);
        salmao.setValor(BigDecimal.valueOf(70.00));
        salmao.setCategoria(categoria);

        // PratoDao
        CardapioDao pratoDao = new CardapioDao(entityManager);
        // iniciar transação
        entityManager.getTransaction().begin();
        // persistir
        pratoDao.cadastrar(feijoada);
        entityManager.flush();
        pratoDao.cadastrar(salmao);
        entityManager.flush();
        System.out.println("O Prato consultado foi :" + pratoDao.buscarPorId(1));
        System.out.println("O Prato consultado foi :" + pratoDao.buscarPorId(2));
        // commit
        //entityManager.getTransaction().commit();
        // fechar
        entityManager.close();

    }
}
