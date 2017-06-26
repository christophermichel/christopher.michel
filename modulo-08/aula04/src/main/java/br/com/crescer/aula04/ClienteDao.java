package br.com.crescer.aula04;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author chris
 */
public class ClienteDao implements CrudDao<Cliente, Long> {

    private final  EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager em = emf.createEntityManager();
    private final  Session session = em.unwrap(Session.class);
    
    @Override
    public Cliente save(Cliente cliente) {
       em.getTransaction().begin();
       session.saveOrUpdate(cliente);
       session.getTransaction().commit();
       em.close();
       emf.close();
       return cliente;
    }

    @Override
    public void remove(Cliente cliente) {
       em.getTransaction().begin();
       em.remove(cliente);
       em.getTransaction().commit();
       em.close();
       emf.close();
    }

    @Override
    public Cliente loadById(Long id) {
       return em.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> findAll() {
        em.getTransaction().begin();
        Criteria criteria = session.createCriteria(Cliente.class);
        List<Cliente> cliente = criteria.list();
        em.close();
        emf.close(); 
        return cliente;
    }
    
}
