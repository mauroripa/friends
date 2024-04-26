package com.example.friends.dao;

import com.example.friends.model.Contenuto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ContenutoDao extends CrudRepository<Contenuto, Integer> {

}
