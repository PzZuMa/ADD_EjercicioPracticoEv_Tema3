package org.example;

import org.example.dao.DataServices;
import org.example.models.Opinion;
import org.example.models.Pelicula;

/**
 * Clase main de la aplicación
 */
public class Aplication {
    public static void main(String[] args) {
        //Historia de usuario 1:
        Pelicula peli = new Pelicula();
        peli.setTitulo("El señor de los anillos");
        DataServices.newMovie(peli);
        System.out.println("Añadimos 'El señor de los anillos' a la base de datos.");
        DataServices.allMovies().forEach(System.out::println);

        //Historia de usuario 2:
        System.out.println("\nOpiniones de 'user1@example.com':");
        DataServices.userOpinions("user1@example.com").forEach(System.out::println);

        //Historia de usuario 3:

        System.out.println("\nAñadimos opiniones a 'Inception'.");
        Opinion opinion1 = new Opinion();
        opinion1.setDescripcion("No me ha gustado mucho");
        opinion1.setPuntuacion(1);
        opinion1.setUsuario("user1@example.com");
        DataServices.addOpinion(opinion1, 1L);

        Opinion opinion2 = new Opinion();
        opinion2.setDescripcion("Asquerosa");
        opinion2.setPuntuacion(0);
        opinion2.setUsuario("user1@example.com");
        DataServices.addOpinion(opinion2, 1L);

        System.out.println("\nOpiniones de 'user1@example.com':");
        DataServices.userOpinions("user1@example.com").forEach(System.out::println);

        //Historia de usuario 4:
        System.out.println("\nTitulo de la/s pelicula/s con puntuación menor o igual a 3:");
        DataServices.titleScore().forEach(System.out::println);


    }
}