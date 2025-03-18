package com.lhcamposs.service;

import com.lhcamposs.dao.LivroDAO;
import com.lhcamposs.entity.Livro;
import java.util.List;

public class LivroService {

    private final LivroDAO livroDAO = new LivroDAO();

    public Livro salvar(Livro livro) {
        return livroDAO.salvar(livro);
    }

    public List<Livro> buscarTodos() {
        return livroDAO.buscarTodos();
    }

    public Livro buscarPorId(Long id) {
        return livroDAO.buscarPorId(id);
    }

    public Livro atualizarLivro(Long id, Livro livro) {
        return livroDAO.atualizarLivro(id, livro);
    }

    public void deletar(Long id) {
        livroDAO.deletar(id);
    }
}