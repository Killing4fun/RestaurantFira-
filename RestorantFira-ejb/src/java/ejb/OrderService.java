/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import com.example.entities.Order;
import com.example.entities.OrderItem;
import com.example.entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OrderService {
    @PersistenceContext
    private EntityManager em;

    // Place a new order
    public void placeOrder(Order order) {
        em.persist(order);
    }

    // Retrieve orders for a specific user
    public List<Order> getOrdersByUser(User user) {
        return em.createQuery("SELECT o FROM Order o WHERE o.user = :user", Order.class)
                 .setParameter("user", user)
                 .getResultList();
    }

    // Retrieve an order by ID
    public Order findOrderById(Integer orderId) {
        return em.find(Order.class, orderId);
    }
}