package main.java.controller;

import main.java.dao.TodoDao;
import main.java.dao.TodoDaoWorker;
import main.java.model.Todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/")
public class TodoController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TodoDao todoDao;

    public void init() {
        todoDao = new TodoDaoWorker();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/new":
                    showNewForm(req, resp);
                    break;
                case "/insert":
                    insertTodo(req, resp);
                    break;
                case "/delete":
                    deleteTodo(req, resp);
                    break;
                case "/edit":
                    showEditForm(req, resp);
                    break;
                case "/update":
                    updateTodo(req, resp);
                    break;
                case "/list":
                    listTodo(req, resp);
                    break;
                default:
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("login/login.jsp");
                    requestDispatcher.forward(req, resp);
                    break;
            }
        } catch (ServletException e) {
            e.printStackTrace();
        }
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("todo/todo-form.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void insertTodo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        Todo newTodo = new Todo(req.getParameter("username"), req.getParameter("title"),
                req.getParameter("description"), LocalDate.parse(req.getParameter("targetDate"), dtf),
                Boolean.parseBoolean(req.getParameter("isDone")));
        todoDao.insertTodo(newTodo);
        resp.sendRedirect("list");
    }

    private void deleteTodo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        todoDao.deleteTodo(id);
        resp.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Todo existTodo = todoDao.selectTodo(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("todo/todo-form.jsp");
        req.setAttribute("todo", existTodo);
        requestDispatcher.forward(req, resp);
    }

    private void updateTodo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        Todo updateTodo = new Todo(req.getParameter("username"), req.getParameter("title"),
                req.getParameter("description"), LocalDate.parse(req.getParameter("targetDate"), dtf),
                Boolean.parseBoolean(req.getParameter("isDone")));
        todoDao.updateTodo(updateTodo);
        resp.sendRedirect("list");
    }

    private void listTodo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Todo> listTodo = todoDao.selectAllTodos();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("todo/todo-list.jsp");
        req.setAttribute("listTodo", listTodo);
        requestDispatcher.forward(req, resp);
    }
}
