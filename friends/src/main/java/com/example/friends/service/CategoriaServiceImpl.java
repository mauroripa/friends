package com.example.friends.service;

import com.example.friends.dao.CategoriaDao;
import com.example.friends.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public List<Categoria> listaCategorie() {
        return (List<Categoria>) categoriaDao.findAll();
    }

    @Override
    public Categoria getCategoriaById(int id) {
        return categoriaDao.findById(id).orElse(null);
    }

    @Override
    public void addCategoria(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void removeCategoria(int id) {
        categoriaDao.deleteById(id);
    }

    @Override
    public Categoria getCategoriaByName(String nomeCategoria) {
        return categoriaDao.findCategorieByNomeCategoria(nomeCategoria);
    }
}
