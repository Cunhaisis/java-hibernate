package br.devisis.java.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Inserir {

    private static EntityManagerFactory entityManagerFactory;

    public static void main(String args[]) {

        entityManagerFactory = Persistence.createEntityManagerFactory("javahibernate");

        Pessoa pessoa = new Pessoa();
        Pessoa pessoa1 = new Pessoa();
        pessoa.setNome("Ted Mosby");
        pessoa.setProfissao("Arquiteto");
        pessoa.setDtNascimento("19780425");

        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

            System.out.println("Insert:" + e.getMessage());

        } finally {
            em.close();
        }
    }


    }

