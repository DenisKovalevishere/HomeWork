package ru.kovalev.hibernate.film;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.kovalev.hibernate.film.model.Director;
import ru.kovalev.hibernate.film.model.Movie;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
       
    	Configuration configuration= new Configuration().addAnnotatedClass(Director.class)
     		   .addAnnotatedClass(Movie.class);
     	
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();
     	
        
        try {
        session.beginTransaction();
        
        
        
        
        session.getTransaction().commit();
        
  
       
        } finally {
        sessionFactory.close();
        }
     }
    	
    }

