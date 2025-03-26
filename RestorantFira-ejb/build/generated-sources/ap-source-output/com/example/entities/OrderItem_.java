package com.example.entities;

import com.example.entities.MenuItem;
import com.example.entities.Order;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-01-08T16:47:37")
@StaticMetamodel(OrderItem.class)
public class OrderItem_ { 

    public static volatile SingularAttribute<OrderItem, Double> unitPrice;
    public static volatile SingularAttribute<OrderItem, Integer> quantity;
    public static volatile SingularAttribute<OrderItem, Integer> orderItemId;
    public static volatile SingularAttribute<OrderItem, Double> subtotal;
    public static volatile SingularAttribute<OrderItem, MenuItem> menuItem;
    public static volatile SingularAttribute<OrderItem, Order> order;

}