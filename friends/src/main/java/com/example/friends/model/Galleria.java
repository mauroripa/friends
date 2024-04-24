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

    @ManyToOne(cascade = CascadeType.REFRESH) // DA CHIEDERE
    @JoinColumn(name = "fk_id_contenuto", referencedColumnName = "id_contenuto")
    private Contenuto contenuto;

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
