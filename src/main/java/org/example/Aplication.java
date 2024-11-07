package org.example;

import org.example.dao.HibernateUtil;
import org.hibernate.Session;

public class Aplication {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
    }
}