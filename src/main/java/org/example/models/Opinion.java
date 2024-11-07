package org.example.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


/**
 * Clase que representa la entidad 'Opinion'
 */
@Data
@Entity
@Table(name = "opinion")
public class Opinion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descripcion;
    private String usuario;
    private Integer puntuacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    @Override
    public String toString() {
        return "ID: " + id +
                ", Usuario: " + usuario +
                ", Puntuacion: " + puntuacion +
                ", Pelicula: " + pelicula.getTitulo() +
                ", Descripcion: " + descripcion;
    }
}