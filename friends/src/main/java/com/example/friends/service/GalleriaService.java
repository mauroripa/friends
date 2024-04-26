package com.example.friends.service;

import com.example.friends.model.Galleria;

import java.util.List;

public interface GalleriaService {
    List<Galleria> listaFoto();
    Galleria getFotoById(int id);
}
