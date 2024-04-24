package com.example.friends.service;


import com.example.friends.model.Admin;
import jakarta.servlet.http.HttpSession;

import java.util.List;

public interface AdminService {

  boolean loggaAdmin(String username, String password, HttpSession session);



}
