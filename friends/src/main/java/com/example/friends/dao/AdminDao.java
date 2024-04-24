package com.example.friends.dao;

import com.example.friends.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminDAO extends CrudRepository<Admin, Long>
{
    Admin findByUsername(String username);
}
