package com.example.friends.dao;

import com.example.friends.model.Galleria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GalleriaDao extends CrudRepository<Galleria, Integer> {

}
