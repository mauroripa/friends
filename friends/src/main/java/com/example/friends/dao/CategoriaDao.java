package com.example.friends.dao;

import com.example.friends.model.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaDao extends CrudRepository<Categoria, Integer> {
}
