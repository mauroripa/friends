package com.example.friends.service;

import com.example.friends.model.Categoria;

import java.util.List;

public interface CategoriaService {
    List<Categoria> listaCategorie();
    Categoria getCategoriaById(int id);
    void addCategori(Categoria categoria);
}
