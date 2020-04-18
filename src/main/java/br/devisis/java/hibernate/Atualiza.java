package br.devisis.java.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


public class Atualiza {

    private static EntityManagerFactory   entityManagerFactory;

    public static void main (String args[]) {

        entityManagerFactory = Persistence.createEntityManagerFactory("javahibernate");

        List<Pessoa> pessoas = null;

        EntityManager em = entityManagerFactory.createEntityManager();

        try {
            Pessoa pessoa = em.find(Pessoa.class,  1l);

            pessoa.setNome("Ted Evelyn Mosby");
            pessoa.setProfissao("Professor de Arquitetura");
            pessoa.setDtNascimento("19790425");

            em.getTransaction().begin();
            em.merge(pessoa);
            em.getTransaction().commit();


        } catch (Exception e) {
            em.getTransaction().rollback();

            System.out.println("UPDADTE: " + e.getMessage());
        }finally {
            em.close();
        }
    }
}
