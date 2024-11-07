package org.example.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

/**
 * Clase que representa la entidad de la base de datos 'Pelicula'
 */
@Data
@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;

    @OneToMany(mappedBy = "pelicula",fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Opinion> opiniones = new ArrayList<>();

    public void addOpinion(Opinion opinion) {
        opinion.setPelicula(this);
        this.opiniones.add(opinion);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Titulo: " + titulo +
                ", Opiniones: { " + opiniones + " }";
    }
}