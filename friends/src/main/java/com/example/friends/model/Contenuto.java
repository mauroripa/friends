package com.example.friends.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contenuti")
public class Contenuto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contenuto")
    private int id;

    @Column
    private String titolo;

    @Column
    private String descrizione;

    @Column(name = "sotto_descrizione") // Aggiunta
    private String sottoDescrizione; // Aggiunta

    @ManyToOne
    @JoinColumn(name = "fk_id_categoria", referencedColumnName = "id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "contenuto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Galleria> immagini = new ArrayList<>();

    // Getters e Setters

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

    public List<Galleria> getImmagini() {
        return immagini;
    }

    public void setImmagini(List<Galleria> immagini) {
        this.immagini = immagini;
    }

    public String getSottoDescrizione() {
        return sottoDescrizione;
    }

    public void setSottoDescrizione(String sottoDescrizione) {
        this.sottoDescrizione = sottoDescrizione;
    }
}