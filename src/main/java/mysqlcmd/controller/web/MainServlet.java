package mysqlcmd.controller.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws javax.servlet.ServletException, IOException {

        String requestUrl = req.getRequestURI();
        String action = requestUrl.substring(req.getContextPath().length(),
                requestUrl.length());

        if (action.startsWith("/menu")) {
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        } else if (action.startsWith("help")) {
            req.getRequestDispatcher("help.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws javax.servlet.ServletException, IOException {
        System.out.println(req.getParameterMap().toString());
    }
}
