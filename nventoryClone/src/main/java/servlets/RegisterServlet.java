// src/main/java/com/inventory/servlet/RegisterServlet.java
package servlets;

import pojo.User;
import dao.UserDao;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        UserDao userDao = new UserDao();
        try {
            if (userDao.isEmailRegistered(email)) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                response.getWriter().println("Error: The email is already registered.");
            } else {
                User user = new User(name, email, password);
                userDao.registerUser(user);
                response.getWriter().println("Success: User registered successfully.");
            }
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Registration failed: " + e.getMessage());
        }
    }
}