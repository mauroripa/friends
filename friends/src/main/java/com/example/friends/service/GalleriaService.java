package com.example.friends.service;

import com.example.friends.dao.GalleriaDao;
import com.example.friends.model.Galleria;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface GalleriaService {
    List<Galleria> getFotoByContenutoId(int idContenuto);

    List<Galleria> listaFoto();
    Galleria getFotoById(int id);
}
