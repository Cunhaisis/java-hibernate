package br.devisis.java.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Buscar {
    public static void main (String args[]){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("javahibernate");

        List<Pessoa> pessoas = null;

        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            pessoas = em.createQuery("from Pessoa").getResultList();


        } catch (Exception e){
            System.out.println("List ALL :" + e.getMessage());
        }finally {
            em.close();
        }
        if (pessoas != null){
            pessoas.forEach(System.out::println);
        }

    }
}