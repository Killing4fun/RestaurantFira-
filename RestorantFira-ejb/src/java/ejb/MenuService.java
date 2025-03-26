/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import com.example.entities.Category;
import com.example.entities.MenuItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MenuService {
    @PersistenceContext
    private EntityManager em;
    
    public List<Category> getAllCategories() {
        return em.createQuery("SELECT c FROM Category c ORDER BY c.categoryId", Category.class)
                 .getResultList();
    }
    
    public List<MenuItem> getMenuItemsByCategory(Integer categoryId) {
        return em.createQuery(
            "SELECT m FROM MenuItem m WHERE m.category.categoryId = :categoryId", 
            MenuItem.class)
            .setParameter("categoryId", categoryId)
            .getResultList();
    }
    
    public MenuItem getMenuItem(Integer itemId) {
        return em.find(MenuItem.class, itemId);
    }
}