package com.example.friends.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contenuti")
public class Contenuto {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name ="id_contenuto")
    private int id;

    @Column
    private String titolo;

    @Column
    private String descrizione;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_id_categoria", referencedColumnName = "id_categoria")
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.REFRESH) // DA CHIEDERE
    @JoinColumn(name = "fk_id_galleria", referencedColumnName = "id_galleria")
    private Galleria galleria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Galleria getGalleria() {
        return galleria;
    }

    public void setGalleria(Galleria galleria) {
        this.galleria = galleria;
    }
}
