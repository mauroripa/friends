package com.example.friends.model;

import jakarta.persistence.*;

@Entity
@Table(name = "galleria")
public class Galleria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_galleria")
    private int id;

    @Column(name = "foto")
    private String galleria;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_id_contenuto", referencedColumnName = "id_contenuto")
    private Contenuto contenuto;

    public Contenuto getContenuto() {
        return contenuto;
    }

    public void setContenuto(Contenuto contenuto) {
        this.contenuto = contenuto;
    }

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
