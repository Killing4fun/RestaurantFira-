package com.example.entities;

import com.example.entities.OrderItem;
import com.example.entities.User;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-01-08T16:47:37")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, Double> totalAmount;
    public static volatile SingularAttribute<Order, Integer> orderId;
    public static volatile SingularAttribute<Order, User> user;
    public static volatile SingularAttribute<Order, Timestamp> orderDate;
    public static volatile ListAttribute<Order, OrderItem> orderItems;
    public static volatile SingularAttribute<Order, String> status;

}