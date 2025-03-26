/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managedBeans;

import ejb.OrderService;
import com.example.entities.Order;
import com.example.entities.OrderItem;
import com.example.entities.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class OrderBean implements Serializable {
    @EJB
    private OrderService orderService;

    private User loggedInUser; // Injected from UserBean
    private List<OrderItem> cart = new ArrayList<>();

    // Add item to cart
    public void addItemToCart(OrderItem item) {
        cart.add(item);
    }

    // Place an order
    public String placeOrder() {
        Order order = new Order();
        order.setUser(loggedInUser);
        order.setOrderDate(new java.sql.Timestamp(System.currentTimeMillis()));
        order.setOrderItems(cart);
        double total = cart.stream().mapToDouble(OrderItem::getSubtotal).sum();
        order.setTotalAmount(total);
        orderService.placeOrder(order);
        cart.clear();
        return "orderConfirmation.xhtml";
    }

    // Retrieve orders for logged-in user
    public List<Order> getMyOrders() {
        return orderService.getOrdersByUser(loggedInUser);
    }

    // Getters and setters
    public List<OrderItem> getCart() { return cart; }
    public void setCart(List<OrderItem> cart) { this.cart = cart; }
}