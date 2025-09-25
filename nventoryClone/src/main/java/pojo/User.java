// src/main/java/com/inventory/model/User.java
package pojo;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;

    // Constructor for new users (for registration)
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Constructor for retrieving from database
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setId(int id) { this.id = id; }
    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}