package br.com.caelum.ingresso.dao;

import br.com.caelum.ingresso.model.Compra;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by matheusbrandino on 5/17/17.
 */
@Repository
public class CompraDao {

    @PersistenceContext
    private EntityManager manager;


    public void save(Compra compra) {
        manager.persist(compra);
    }
}
