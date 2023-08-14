package kenkoro.net.basicauth;

import static kenkoro.net.basicauth.context.Context.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.DriverManager;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final var uname = request.getParameter("username");
        final var upwd = request.getParameter("password");

        var session = request.getSession();
        RequestDispatcher dispatcher = null;
        try {
            Class.forName(LOAD_MYSQL_DRIVER);
            var connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
            var prepStatement =
                    connection.prepareStatement("select * from users where uname = ? and upwd = ?");
            prepStatement.setString(1, uname);
            prepStatement.setString(2, upwd);

            var result = prepStatement.executeQuery();
            if (result.next()) {
                session.setAttribute("name", result.getString("uname"));
                dispatcher = request.getRequestDispatcher(INDEX_DISPATHCER);
            } else {
                request.setAttribute("status", "failed");
                dispatcher = request.getRequestDispatcher(LOGIN_DISPATCHER);
            }

            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
