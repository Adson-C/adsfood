package org.example.util;

import org.example.dao.CardapioDao;
import org.example.dao.CategoriaDao;
import org.example.entity.Cardapio;
import org.example.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {

    private CargaDeDadosUtil(){}

    public static void cadastarCategorias(EntityManager entityManager) {
        Categoria entrada = new Categoria();
        entrada.setNome("Entrada");
        Categoria salada = new Categoria();
        salada.setNome("Salada");
        Categoria principal = new Categoria();
        principal.setNome("Principal");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.cadastrar(entrada);
        entityManager.flush();
        categoriaDao.cadastrar(salada);
        entityManager.flush();
        categoriaDao.cadastrar(principal);
        entityManager.flush();
        entityManager.clear();
    }

    public static void cadastrarProdutosCardapio(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.consultarTodos();

        Cardapio spaguetti = new Cardapio();
        spaguetti.setNome("Spaguetti");
        spaguetti.setDescricao("Spaguetti ao molho de tomate");
        spaguetti.setDisponivel(true);
        spaguetti.setValor(BigDecimal.valueOf(60.00));
        spaguetti.setCategoria(categorias.get(1));

        Cardapio bife = new Cardapio();
        bife.setNome("Bife");
        bife.setDescricao("Bife ao molho de tomate");
        bife.setDisponivel(true);
        bife.setValor(BigDecimal.valueOf(59.00));
        bife.setCategoria(categorias.get(0));

        Cardapio burrata = new Cardapio();
        burrata.setNome("burrata");
        burrata.setDescricao("Tomates queimados, rúcula e torrada");
        burrata.setDisponivel(true);
        burrata.setValor(BigDecimal.valueOf(15.00));
        burrata.setCategoria(categorias.get(2));

        Cardapio cordeiro = new Cardapio();
        cordeiro.setNome("Cordeiro");
        cordeiro.setDescricao("Cordeiro com risoto de funghi");
        cordeiro.setDisponivel(true);
        cordeiro.setValor(BigDecimal.valueOf(88.00));
        cordeiro.setCategoria(categorias.get(2));

        Cardapio bruschetta = new Cardapio();
        bruschetta.setNome("bruschetta");
        bruschetta.setDescricao("Ragu de linguica e torradinhas");
        bruschetta.setDisponivel(true);
        bruschetta.setValor(BigDecimal.valueOf(25.00));
        bruschetta.setCategoria(categorias.get(0));

        Cardapio scappeta = new Cardapio();
        scappeta.setNome("scappeta");
        scappeta.setDescricao("Ragu de linguica e torradinhas");
        scappeta.setDisponivel(true);
        scappeta.setValor(BigDecimal.valueOf(59.00));
        scappeta.setCategoria(categorias.get(0));

        Cardapio caprese = new Cardapio();
        caprese.setNome("caprese");
        caprese.setDescricao("Mini rucula e mucarela");
        caprese.setDisponivel(true);
        caprese.setValor(BigDecimal.valueOf(47.00));
        caprese.setCategoria(categorias.get(1));

        Cardapio caesar = new Cardapio();
        caesar.setNome("caesar");
        caesar.setDescricao("Salada de franco com molho ceasar");
        caesar.setDisponivel(true);
        caesar.setValor(BigDecimal.valueOf(40.00));
        caesar.setCategoria(categorias.get(1));

        Cardapio chevre = new Cardapio();
        chevre.setNome("chevre");
        chevre.setDescricao("Chevre, Mix de folhas, mostarda e mel");
        chevre.setDisponivel(true);
        chevre.setValor(BigDecimal.valueOf(59.00));
        chevre.setCategoria(categorias.get(1));

        cardapioDao.cadastrar(spaguetti);
        cardapioDao.cadastrar(bife);
        cardapioDao.cadastrar(cordeiro);
        cardapioDao.cadastrar(burrata);
        cardapioDao.cadastrar(bruschetta);
        cardapioDao.cadastrar(scappeta);
        cardapioDao.cadastrar(caprese);
        cardapioDao.cadastrar(caesar);
        cardapioDao.cadastrar(chevre);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

}
