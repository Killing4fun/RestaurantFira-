/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managedBeans;

import ejb.MenuService;
import com.example.entities.Category;
import com.example.entities.MenuItem;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class MenuBean implements Serializable {
    @EJB
    private MenuService menuService;
    
    private Integer selectedCategoryId;
    private List<MenuItem> currentMenuItems;
    
    public List<Category> getCategories() {
        return menuService.getAllCategories();
    }
    
    public void onCategorySelect() {
        if (selectedCategoryId != null) {
            currentMenuItems = menuService.getMenuItemsByCategory(selectedCategoryId);
        }
    }
    
    // Getters and Setters
    public Integer getSelectedCategoryId() { return selectedCategoryId; }
    public void setSelectedCategoryId(Integer selectedCategoryId) { 
        this.selectedCategoryId = selectedCategoryId; 
    }
    
    public List<MenuItem> getCurrentMenuItems() { return currentMenuItems; }
}