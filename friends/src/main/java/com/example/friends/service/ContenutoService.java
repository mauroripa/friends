package com.example.friends.service;

import com.example.friends.model.Contenuto;

import java.util.List;

public interface ContenutoService {
    List<Contenuto> listaContenuti();
    Contenuto getContenutoById(int id);


    void addContenuto(Contenuto contenuto);
    void removeContenuto(int id);
}
