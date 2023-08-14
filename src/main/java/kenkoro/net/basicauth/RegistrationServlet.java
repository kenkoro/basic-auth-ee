package kenkoro.net.basicauth;

import static kenkoro.net.basicauth.context.Context.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final var uname = request.getParameter("name");
        final var upwd = request.getParameter("pass");
        final var uemail = request.getParameter("email");
        final var umobile = request.getParameter("contact");

        RequestDispatcher dispatcher = null;
        Connection connection = null;
        try {
            Class.forName(LOAD_MYSQL_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            var prepStatement =
                    connection.prepareStatement(
                            "insert into users(uname, upwd, uemail, umobile) values(?, ?, ?, ?)");
            prepStatement.setString(1, uname);
            prepStatement.setString(2, upwd);
            prepStatement.setString(3, uemail);
            prepStatement.setString(4, umobile);

            final var rowCount = prepStatement.executeUpdate();
            dispatcher = request.getRequestDispatcher(REGISTER_DISPATCHER);
            if (rowCount > 0) request.setAttribute("status", REGISTER_SUCCESS);
            else request.setAttribute("status", REGISTER_FAIL);

            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }
}
