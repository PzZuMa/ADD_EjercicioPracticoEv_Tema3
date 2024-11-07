package org.example.dao;

import org.example.models.Opinion;
import org.example.models.Pelicula;
import org.hibernate.Session;

import java.util.List;

public class DataServices {
    /**
     * Muestra toda la lista de peliculas
     * @return
     */
    public static List<Pelicula> allMovies() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Pelicula", Pelicula.class).list();
        }
    }

    /**
     * Historia de usuario 1:
     * Método que añade una nueva película a la base de datos.
     *
     * @param movie Película a añadir.
     */
    public static void newMovie(Pelicula movie) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(movie);
            session.getTransaction().commit();
        }
    }

    /**
     * Historia de usuario 2:
     * Metodo para obtener la lista de opiniones de un usuario en especifico, indicando su correo.
     *
     * @param emailUser Correo del usuario.
     *
     * @return List
     */
    public static List<Opinion> userOpinions(String emailUser) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT o FROM Opinion o WHERE o.usuario = :nombre", Opinion.class)
                    .setParameter("nombre", emailUser)
                    .list();
        }
    }

    /**
     * Historia de usuario 3:
     * Método que permite añadir una nueva opinión a una película ya existente.
     *
     * @param opinion Opinión a añadir.
     * @param idMovie Id de la película a la que se le añade la opinión.
     */

    public static void addOpinion(Opinion opinion, Long idMovie) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Pelicula movie = session.get(Pelicula.class, idMovie);
            movie.addOpinion(opinion);
            session.beginTransaction();
            session.persist(opinion);
            session.getTransaction().commit();
        }
    }

    /**
     * Historia de usuario 4:
     * Método que permite obtener un listado de los titulos de las películas
     * que al menos tienen una puntuación igual o inferior a 3.
     *
     * @return List
     */

    public static List<String> titleScore() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("SELECT DISTINCT(p.titulo) FROM Pelicula p JOIN Opinion o ON p.id = o.pelicula.id WHERE o.puntuacion <= 3", String.class)
                    .list();
        }
    }
}
