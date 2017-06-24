package br.com.crescer.aula04;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author carloshenrique
 */
public class Run {

    public static void main(String[] args) {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JAVA");
        final EntityManager em = emf.createEntityManager();
        
        final Pessoa cliente = em.find(Pessoa.class, 3l); 
        System.out.println(cliente.getNome());
        
        em.getTransaction().begin();
        
        
        cliente.setNome("ldnqldl");
        em.merge(cliente);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}