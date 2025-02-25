package org.example.service.teste;

import org.example.dao.CardapioDao;
import org.example.dao.ClienteDao;
import org.example.dao.OrdemDao;
import org.example.entity.Cliente;
import org.example.entity.OdermCardapio;
import org.example.entity.Ordem;
import org.example.util.CargaDeDadosUtil;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerAdsFood();
        entityManager.getTransaction().begin();

        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);

        CardapioDao cardapioDao = new CardapioDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);

        // criando Cliente
        Cliente felipe = new Cliente("Felipe", "11111111111", "12345678");
        Ordem ordem = new Ordem(felipe);
        ordem.addOrdemCardapio(new OdermCardapio(ordem, cardapioDao.buscarPorId(1), 2));
        clienteDao.cadastrar(felipe);
        ordemDao.cadastrar(ordem);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
