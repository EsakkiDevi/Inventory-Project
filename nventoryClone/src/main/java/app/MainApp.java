// src/main/java/com/inventory/MainApp.java
package app;

import dao.UserDao;
import pojo.User;

public class MainApp {
    public static void main(String[] args) {
        UserDao userDAO = new UserDao();

        // **Registration Example**
        try {
            String newUserName = "John Doe";
            String newUserEmail = "john.doe@example.com";
            String newUserPassword = "password123";

            if (userDAO.isEmailRegistered(newUserEmail)) {
                System.out.println("Registration failed: " + newUserEmail + " is already registered.");
            } else {
                User newUser = new User(newUserName, newUserEmail, newUserPassword);
                userDAO.registerUser(newUser);
                System.out.println("Registration successful for user: " + newUserEmail);
            }
        } catch (Exception e) {
            System.err.println("Registration process error: " + e.getMessage());
        }

        System.out.println("\n-------------------------------\n");

        // **Login Example**
        try {
            String loginEmail = "john.doe@example.com";
            String loginPassword = "password123";

            if (userDAO.validateUser(loginEmail, loginPassword)) {
                System.out.println("Login successful for user: " + loginEmail);
            } else {
                System.out.println("Login failed: Invalid credentials for user: " + loginEmail);
            }

            // Example with wrong password
            String wrongPassword = "wrong_password";
            if (userDAO.validateUser(loginEmail, wrongPassword)) {
                System.out.println("Login successful (This should not happen)");
            } else {
                System.out.println("Login failed as expected: Invalid credentials for user: " + loginEmail);
            }

        } catch (Exception e) {
            System.err.println("Login process error: " + e.getMessage());
        }
    }
}