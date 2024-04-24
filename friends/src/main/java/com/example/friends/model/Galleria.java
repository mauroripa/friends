package com.example.friends.model;

import jakarta.persistence.*;

@Entity
@Table(name = "galleria")
public class Galleria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_galleria")
    private int id;

    @Column
    private String galleria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGalleria() {
        return galleria;
    }

    public void setGalleria(String galleria) {
        this.galleria = galleria;
    }
}
