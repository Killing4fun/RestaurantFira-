/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import com.example.entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class UserService {
    @PersistenceContext
    private EntityManager em;

    // Authenticate user
    public User authenticate(String username, String password) {
        try {
            return em.createQuery(
                "SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
        } catch (NoResultException e) {
            return null; // User not found
        }
    }

    // Register a new user
    public void registerUser(User user) {
        em.persist(user);
    }

    // Find a user by ID
    public User findUserById(Integer userId) {
        return em.find(User.class, userId);
    }
}