package br.devisis.java.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Deleta {
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String args[]){

        entityManagerFactory = Persistence.createEntityManagerFactory("javahibernate");

        EntityManager em = entityManagerFactory.createEntityManager();

        try{
            em.getTransaction().begin();
            Pessoa pessoa = em.find(Pessoa.class, 1l);
            em.remove(pessoa);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
         System.out.println("DELETE:" + e.getMessage());
        }finally {
            em.close();
        }
    }
}
