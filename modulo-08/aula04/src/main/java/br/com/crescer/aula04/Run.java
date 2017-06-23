package br.com.crescer.aula04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author carloshenrique
 */
public class Run {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();
        
        final Cliente cliente = em.find(Cliente.class, 1l); 
        System.out.println(cliente.getNome());
        
        em.getTransaction().begin();
        em.remove(cliente);
        
        cliente.setId(1l);
        cliente.setNome("Christopher");
        em.persist(cliente);
        

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}