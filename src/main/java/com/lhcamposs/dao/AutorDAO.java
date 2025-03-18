package com.lhcamposs.dao;

import com.lhcamposs.entity.Autor;
import com.lhcamposs.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class AutorDAO {

    public Autor salvar(Autor autor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(autor);
            transaction.commit();
            return autor;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    public List<Autor> buscarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Autor", Autor.class).list();
        }
    }

    public Autor buscarPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Autor.class, id);
        }
    }

    public Autor atualizar(Long id, Autor autorAtualizado) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Autor autor = session.get(Autor.class, id);
            if (autor != null) {
                autor.setNome(autorAtualizado.getNome());
                session.merge(autor);
                transaction.commit();
            }
            return autor;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    public void deletar(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Autor autor = session.get(Autor.class, id);
            if (autor != null) session.remove(autor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }
}