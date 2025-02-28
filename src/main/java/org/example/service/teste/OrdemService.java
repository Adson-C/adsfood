package org.example.service.teste;

import org.example.dao.CardapioDao;
import org.example.dao.ClienteDao;
import org.example.dao.EnderecoDao;
import org.example.dao.OrdemDao;
import org.example.entity.Cliente;
import org.example.entity.Endereco;
import org.example.entity.Ordem;
import org.example.entity.OrdensCardapio;
import org.example.util.CargaDeDadosUtil;
import org.example.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerAdsFood();
        entityManager.getTransaction().begin();

        CargaDeDadosUtil.cadastarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarOrdensClientes(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);
        System.out.println(enderecoDao.consultarClientes(null, null, "lapa"));
//        System.out.println(enderecoDao.consultarClientes("BA", "Salvador", "Rio Vermelho"));
//        System.out.println(clienteDao.consultarPorNome("Denise"));
//        Ordem ordem = ordemDao.buscarPorId(2);
//        System.out.println(ordem.getValorTotal());
//        System.out.println(ordemDao.consultarItensMaisVendidos());
//        CardapioDao cardapioDao = new CardapioDao(entityManager);
//        ClienteDao clienteDao = new ClienteDao(entityManager);
//        OrdemDao ordemDao = new OrdemDao(entityManager);
//
//        Endereco endereco = new Endereco("000000000","sem teto","apto 1001","Sao Paulo","SP");
//        Cliente felipe = new Cliente("111111111111","Felipe");
//        felipe.addEndereco(endereco);
//        Ordem ordem = new Ordem(felipe);
//        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(1),2));
//        ordem.addOrdensCardapio(new OrdensCardapio(cardapioDao.consultarPorId(2),3));
//        clienteDao.cadastrar(felipe);
//        ordemDao.cadastrar(ordem);
//        System.out.println(ordem);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
