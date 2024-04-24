package com.example.friends.service;


import com.example.friends.model.Admin;

import java.util.List;

public interface AdminService {

    // Metodi per la gestione degli utenti amministratori
    Admin registraAdmin(Admin admin);

    Admin loggaAdmin(String username, String password);

    List<Admin> getAdmins();

    Admin getAdminById(Long id);

    void updateAdmin(Admin admin);

    void deleteAdmin(Long id);
}
