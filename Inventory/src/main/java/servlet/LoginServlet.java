package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.Admindao;
import model.Admin;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = new Admin(username, password);
        Admindao dao = new Admindao();

        if (dao.validate(admin)) {
            HttpSession session = request.getSession();
            session.setAttribute("adminUser", username);
            response.sendRedirect("dashboard.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid Username or Password!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
