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
public class LocacaoDao implements CrudDao<Locacao, Long> {

    private final  EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager em = emf.createEntityManager();
    private final  Session session = em.unwrap(Session.class);
    
    @Override
    public Locacao save(Locacao locacao) {
       em.getTransaction().begin();
       session.saveOrUpdate(locacao);
       session.getTransaction().commit();
       em.close();
       emf.close();
       return locacao;
    }

    @Override
    public void remove(Locacao locacao) {
       em.getTransaction().begin();
       em.remove(locacao);
       em.getTransaction().commit();
       em.close();
       emf.close();
    }

    @Override
    public Locacao loadById(Long id) {
       Locacao locacao = new Locacao();
       em.getTransaction().begin();
       locacao = (Locacao) session.get(Locacao.class, id);
       em.close();
       emf.close();   
       return locacao;
    }

    @Override
    public List<Locacao> findAll() {
        em.getTransaction().begin();
        Criteria criteria = session.createCriteria(Locacao.class);
        List<Locacao> locacao = criteria.list();
        em.close();
        emf.close(); 
        return locacao;
    }
    
}
