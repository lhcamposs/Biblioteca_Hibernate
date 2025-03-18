package com.lhcamposs.service;

import com.lhcamposs.dao.AutorDAO;
import com.lhcamposs.entity.Autor;
import java.util.List;

public class AutorService {

    private final AutorDAO autorDAO = new AutorDAO();

    public Autor salvar(Autor autor) {
        return autorDAO.salvar(autor);
    }

    public List<Autor> buscarTodos() {
        return autorDAO.buscarTodos();
    }

    public Autor buscarPorId(Long id) {
        return autorDAO.buscarPorId(id);
    }

    public Autor atualizar(Long id, Autor autor) {
        return autorDAO.atualizar(id, autor);
    }

    public void deletar(Long id) {
        autorDAO.deletar(id);
    }
}