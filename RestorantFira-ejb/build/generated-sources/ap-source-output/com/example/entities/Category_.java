package com.example.entities;

import com.example.entities.MenuItem;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2025-01-08T16:47:37")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile SingularAttribute<Category, String> name;
    public static volatile ListAttribute<Category, MenuItem> menuItems;
    public static volatile SingularAttribute<Category, Integer> categoryId;

}