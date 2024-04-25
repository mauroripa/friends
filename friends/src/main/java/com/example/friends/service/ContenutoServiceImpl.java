package com.example.friends.service;

import com.example.friends.dao.ContenutoDao;
import com.example.friends.model.Contenuto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
}
