package com.example.friends.dao;

import com.example.friends.model.Galleria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GalleriaDao extends CrudRepository<Galleria, Integer> {

    /*Galleria getFotoByContenutoId(int idContenuto);
    @Query
            (
                    value = "SELECT * FROM galleria WHERE fk_id_contenuto=:n",
                    nativeQuery = true
            )
    List<Galleria> trovaPerId(@Param("n") int idContenuto);*/
/*
    Galleria findByIdContenuto(int idContenuto);

    @Query(value = "SELECT * FROM galleria WHERE fk_id_contenuto = :idContenuto", nativeQuery = true)
    List<Galleria> trovaPerId(@Param("idContenuto") int idContenuto);*/
}
