package com.lhcamposs.service;

import com.lhcamposs.dao.EditoraDAO;
import com.lhcamposs.entity.Editora;
import java.util.List;

public class EditoraService {

    private final EditoraDAO editoraDAO = new EditoraDAO();

    public Editora salvar(Editora editora) {
        return editoraDAO.salvar(editora);
    }

    public List<Editora> buscarTodos() {
        return editoraDAO.buscarTodos();
    }

    public Editora buscarPorId(Long id) {
        return editoraDAO.buscarPorId(id);
    }

    public Editora atualizar(Long id, Editora editora) {
        return editoraDAO.atualizar(id, editora);
    }

    public void deletar(Long id) {
        editoraDAO.deletar(id);
    }
}