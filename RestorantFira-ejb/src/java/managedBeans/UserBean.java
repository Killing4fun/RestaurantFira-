/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managedBeans;

import ejb.UserService;
import com.example.entities.User;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserBean implements Serializable {
    @EJB
    private UserService userService;

    private String username;
    private String password;
    private String email;
    private User loggedInUser;

    // Login action
    public String login() {
        User user = userService.authenticate(username, password);
        if (user != null) {
            loggedInUser = user;
            return loggedInUser.getRole().equals("ADMIN") ? "adminDashboard.xhtml" : "userDashboard.xhtml";
        }
        return "login.xhtml?error=true"; // Redirect back to login on failure
    }

    // Register action
    public String register() {
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setRole("USER"); // Default role
        userService.registerUser(newUser);
        return "login.xhtml";
    }

    // Logout action
    public String logout() {
        loggedInUser = null;
        return "login.xhtml?faces-redirect=true";
    }

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public User getLoggedInUser() { return loggedInUser; }
}