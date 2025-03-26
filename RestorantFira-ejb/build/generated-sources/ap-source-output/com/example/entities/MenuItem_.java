package com.example.entities;

import com.example.entities.Category;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-01-08T16:47:37")
@StaticMetamodel(MenuItem.class)
public class MenuItem_ { 

    public static volatile SingularAttribute<MenuItem, Integer> itemId;
    public static volatile SingularAttribute<MenuItem, Boolean> isAvailable;
    public static volatile SingularAttribute<MenuItem, Double> price;
    public static volatile SingularAttribute<MenuItem, String> name;
    public static volatile SingularAttribute<MenuItem, Category> category;

}