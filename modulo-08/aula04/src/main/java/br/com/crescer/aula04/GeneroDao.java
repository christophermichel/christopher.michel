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
public class GeneroDao implements CrudDao<Genero, Long> {

    private final  EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager em = emf.createEntityManager();
    private final  Session session = em.unwrap(Session.class);
    
    @Override
    public Genero save(Genero genero) {
       em.getTransaction().begin();
       session.saveOrUpdate(genero);
       session.getTransaction().commit();
       em.close();
       emf.close();
       return genero;
    }

    @Override
    public void remove(Genero genero) {
       em.getTransaction().begin();
       em.remove(genero);
       em.getTransaction().commit();
       em.close();
       emf.close();
    }

    @Override
    public Genero loadById(Long id) {
       Genero genero = new Genero();
       em.getTransaction().begin();
       genero = (Genero) session.get(Genero.class, id);
       em.close();
       emf.close();   
       return genero;
    }

    @Override
    public List<Genero> findAll() {
        em.getTransaction().begin();
        Criteria criteria = session.createCriteria(Genero.class);
        List<Genero> genero = criteria.list();
        em.close();
        emf.close(); 
        return genero;
    }
    
}
