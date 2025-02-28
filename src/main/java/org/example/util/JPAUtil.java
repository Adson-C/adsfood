package org.example.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    // persistir no banco de dados
    private static final EntityManagerFactory ADSFOOD = Persistence.createEntityManagerFactory("adsFood");
    // criando um EntityManager
    public static EntityManager getEntityManagerAdsFood() {
        return ADSFOOD.createEntityManager();
    }

}
