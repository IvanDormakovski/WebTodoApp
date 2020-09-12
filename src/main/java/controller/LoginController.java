package main.java.controller;

import main.java.dao.LoginDao;
import main.java.model.LoginBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login/login.jsp");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        authenticate(req, resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private void authenticate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LoginBean loginBean = new LoginBean();
        loginBean.setUserName(req.getParameter("userName"));
        loginBean.setPassword(req.getParameter("password"));

        try {
            if (loginDao.validate(loginBean)) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("todo/todo-list.jsp");
                requestDispatcher.forward(req, resp);
            }
        } catch (ServletException | IOException e) {
            resp.sendRedirect("login/login.jsp");
        }
    }
}
