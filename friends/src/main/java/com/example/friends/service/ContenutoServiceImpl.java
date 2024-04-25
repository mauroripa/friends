package com.example.friends.service;

import com.example.friends.dao.ContenutoDao;
import com.example.friends.model.Contenuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContenutoServiceImpl implements ContenutoService {

    @Autowired
    private ContenutoDao contenutoDao;


    @Override
    public List<Contenuto> listaContenuti() {
        return (List<Contenuto>) contenutoDao.findAll();
    }

    @Override
    public Contenuto getContenutoById(int id) {
        return contenutoDao.findById(id).orElse(null);
    }

    @Override
    public void addContenuto(Contenuto contenuto) {
        contenutoDao.save(contenuto);
    }
}
