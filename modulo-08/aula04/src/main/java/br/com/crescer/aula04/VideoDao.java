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
public class VideoDao implements CrudDao<Video, Long> {

    private final  EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager em = emf.createEntityManager();
    private final  Session session = em.unwrap(Session.class);
    
    @Override
    public Video save(Video video) {
       em.getTransaction().begin();
       session.saveOrUpdate(video);
       session.getTransaction().commit();
       em.close();
       emf.close();
       return video;
    }

    @Override
    public void remove(Video video) {
       em.getTransaction().begin();
       em.remove(video);
       em.getTransaction().commit();
       em.close();
       emf.close();
    }

    @Override
    public Video loadById(Long id) {
       return em.find(Video.class, id);
    }

    @Override
    public List<Video> findAll() {
        em.getTransaction().begin();
        Criteria criteria = session.createCriteria(Video.class);
        List<Video> video = criteria.list();
        em.close();
        emf.close(); 
        return video;
    }
    
}
