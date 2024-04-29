package com.example.friends.service;

import com.example.friends.dao.ContenutoDao;
import com.example.friends.model.Contenuto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ContenutoService {

    // Metodo per ottenere i contenuti in base alla categoria
    public List<Contenuto> getContenutiByCategoria(String categoria);

    List<Contenuto> listaContenuti();
    Contenuto getContenutoById(int id);

    void addContenuto(Contenuto contenuto);
    void removeContenuto(int id);
}
