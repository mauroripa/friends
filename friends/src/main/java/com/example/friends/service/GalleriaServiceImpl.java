package com.example.friends.service;

import com.example.friends.dao.GalleriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleriaServiceImpl implements GalleriaService{
    @Autowired
    GalleriaDao galleriaDao;

    @Override
    public void removeImg(int id) {
        galleriaDao.deleteById(id);
    }
}
