package com.lhcamposs.dao;
import com.lhcamposs.entity.Livro;
import com.lhcamposs.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class LivroDAO {

    public Livro salvar(Livro livro) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(livro);
            transaction.commit();
            return livro;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    public List<Livro> buscarTodos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Livro", Livro.class).list();
        }
    }

    public Livro buscarPorId(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Livro.class, id);
        }
    }

    public Livro atualizarLivro(Long id, Livro livroAtualizado) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Livro livro = session.get(Livro.class, id);
            if (livro != null) {
                livro.setTitulo(livroAtualizado.getTitulo());
                livro.setAnoPub(livroAtualizado.getAnoPub());
                livro.setIsbn(livroAtualizado.getIsbn());
                session.merge(livro);
                transaction.commit();
            }
            return livro;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    public void deletar(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Livro livro = session.get(Livro.class, id);
            if (livro != null) session.remove(livro);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }
}
