package com.example.friends.service;

import com.example.friends.dao.GalleriaDao;
import com.example.friends.model.Galleria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GalleriaServiceImpl implements GalleriaService{
    @Autowired
    private GalleriaDao galleriaDao;

    @Override
    public List<Galleria> getFotoByContenutoId(int idContenuto) {
        Galleria foto = galleriaDao.findByIdContenuto(idContenuto);
        if (foto != null) {
            return List.of(foto); // Converti l'oggetto Galleria in una lista e restituiscilo
        } else {
            return List.of(); // Se non viene trovato nessun oggetto, restituisci una lista vuota
        }
    }

    @Override
    public List<Galleria> listaFoto() {
        return (List<Galleria>) galleriaDao.findAll();
    }

    @Override
    public Galleria getFotoById(int id) {
        return null;
    }
}
