package com.example.friends.service;

import com.example.friends.dao.AdminDao;
import com.example.friends.model.Admin;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean loggaAdmin(String username, String password, HttpSession session) {
        Admin admin = adminDao.findByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            session.setAttribute("admin", admin);
            return true;
        }
        return false;
    }

    @Override
    public List<Admin> getAdmins() {
        return (List<Admin>) adminDao.findAll();
    }

    @Override
    public boolean aggiungiAdmin(String username, String password) {

        Admin adminEsistente = adminDao.findByUsername(username);
        if (adminEsistente != null) {

            return false;
        }


        Admin nuovoAdmin = new Admin();
        nuovoAdmin.setUsername(username);
        nuovoAdmin.setPassword(password);


        adminDao.save(nuovoAdmin);

        return true;
    }

    @Override
    public void rimuoviAdmin(String username) {
        Admin admin = adminDao.findByUsername(username);
        if (admin != null) {
            adminDao.delete(admin);
        }


    }

    @Override
    public Admin getAdmin(int id) {
        return adminDao.findById(id).orElse(null);
    }
}

