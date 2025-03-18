package com.lhcamposs.dao;

import com.lhcamposs.entity.Editora;
import com.lhcamposs.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class EditoraDAO {

    public Editora salvar(Editora editora) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(editora);
            transaction.commit();
            return editora;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    public List<Editora> buscarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Editora", Editora.class).list();
        }
    }

    public Editora buscarPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Editora.class, id);
        }
    }

    public Editora atualizar(Long id, Editora editoraAtualizada) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Editora editora = session.get(Editora.class, id);
            if (editora != null) {
                editora.setNome(editoraAtualizada.getNome());
                session.merge(editora);
                transaction.commit();
            }
            return editora;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    public void deletar(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Editora editora = session.get(Editora.class, id);
            if (editora != null) session.remove(editora);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }
}