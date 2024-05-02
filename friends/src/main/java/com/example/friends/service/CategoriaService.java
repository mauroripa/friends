package com.example.friends.service;

import com.example.friends.model.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> listaCategorie();
    Categoria getCategoriaById(int id);
    void addCategoria(Categoria categoria);
    void removeCategoria(int id);
    Categoria getCategoriaByName(String nomeCategoria);


}
