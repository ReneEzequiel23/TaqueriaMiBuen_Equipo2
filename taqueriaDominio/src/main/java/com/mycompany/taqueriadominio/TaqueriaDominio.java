/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taqueriadominio;

import com.mycompany.taqueriadominio.persistencia.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author ReneEzequiel23 & EdgarAcevedoAcosta
 */
public class TaqueriaDominio {
    public static void main(String[] args) {
        // El nombre debe coincidir con el del persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_taqueriaDominio_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            
            // Crear un nuevo registro
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setNombre("Ejemplo Usuario");
            nuevoUsuario.setCorreo("ejemplo@correo.com");
            
            em.persist(nuevoUsuario); // Guarda el objeto en MySQL
            
            em.getTransaction().commit();
            System.out.println("¡Usuario guardado con éxito!");
            
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
