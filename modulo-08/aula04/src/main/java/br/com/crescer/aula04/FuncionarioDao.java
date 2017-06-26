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
public class FuncionarioDao implements CrudDao<Funcionario, Long> {

    private final  EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
    private final EntityManager em = emf.createEntityManager();
    private final  Session session = em.unwrap(Session.class);
    
    @Override
    public Funcionario save(Funcionario funcionario) {
       em.getTransaction().begin();
       session.saveOrUpdate(funcionario);
       session.getTransaction().commit();
       em.close();
       emf.close();
       return funcionario;
    }

    @Override
    public void remove(Funcionario funcionario) {
       em.getTransaction().begin();
       em.remove(funcionario);
       em.getTransaction().commit();
       em.close();
       emf.close();
    }

    @Override
    public Funcionario loadById(Long id) {
       return em.find(Funcionario.class, id);
    }

    @Override
    public List<Funcionario> findAll() {
        em.getTransaction().begin();
        Criteria criteria = session.createCriteria(Funcionario.class);
        List<Funcionario> funcionarios = criteria.list();
        em.close();
        emf.close(); 
        return funcionarios;
    }
    
}
