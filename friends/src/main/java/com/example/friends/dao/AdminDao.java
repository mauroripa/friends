package com.example.friends.dao;

import com.example.friends.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminDao extends CrudRepository<Admin, Integer>
{
    Admin findByUsername(String username);
}
