package main.java.dao;

import main.java.model.Todo;
import main.java.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDaoWorker implements main.java.dao.TodoDao {
    private static final String INSERT_TODO_TO_SQL = "INSERT INTO todos " +
            "(username, title, description, target_date, is_done) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_TODO = "SELECT * WHERE id = ?";
    private static final String SELECT_ALL_TODOS = "SELECT * FROM todos";
    private static final String DELETE_TODO = "DELETE FROM todos WHERE id = ?";
    private static final String UPDATE_TODO = "UPDATE todos SET " +
            "username = ?, title = ?, description = ?, target_date = ?, is_done = ? WHERE id = ?";

    private PreparedStatement getPreparedStatement(String SQLResponse) {
        PreparedStatement preparedStatement = null;
        try (Connection connection = JDBCUtils.getConnection()) {
            preparedStatement = connection.prepareStatement(SQLResponse);
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return preparedStatement;
    }

    @Override
    public void insertTodo(Todo todo) {
        try (PreparedStatement preparedStatement = getPreparedStatement(INSERT_TODO_TO_SQL)) {
//            PreparedStatement preparedStatement = getPreparedStatement(INSERT_TODO_TO_SQL);
            preparedStatement.setString(1, todo.getUserName());
            preparedStatement.setString(2, todo.getTitle());
            preparedStatement.setString(3, todo.getDescription());
            preparedStatement.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate()));
            preparedStatement.setBoolean(5, todo.isDone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
    }

    @Override
    public Todo selectTodo(long todoId) {
        Todo todo = null;
        try {
            PreparedStatement preparedStatement = getPreparedStatement(SELECT_TODO);
            preparedStatement.setLong(1, todoId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todo = new Todo(resultSet.getLong("id"), resultSet.getString("username"),
                        resultSet.getString("title"), resultSet.getString("description"),
                        resultSet.getDate("target_date").toLocalDate(), resultSet.getBoolean("is_done"));
            }
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return todo;
    }

    @Override
    public List<Todo> selectAllTodos() {
        List<Todo> todos = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getPreparedStatement(SELECT_ALL_TODOS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todos.add(new Todo(resultSet.getLong("id"), resultSet.getString("username"),
                        resultSet.getString("title"), resultSet.getString("description"),
                        resultSet.getDate("target_date").toLocalDate(), resultSet.getBoolean("is_done")));
            }

        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return todos;
    }

    @Override
    public boolean deleteTodo(long todoId) {
        boolean result = false;
        try {
            PreparedStatement preparedStatement = getPreparedStatement(DELETE_TODO);
            preparedStatement.setLong(1, todoId);
            result = (preparedStatement.executeUpdate() > 0);
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return result;
    }

    @Override
    public boolean updateTodo(Todo todo) {
        boolean result = false;
        try {
            PreparedStatement preparedStatement = getPreparedStatement(UPDATE_TODO);
            preparedStatement.setString(1, todo.getUserName());
            preparedStatement.setString(2, todo.getTitle());
            preparedStatement.setString(3, todo.getDescription());
            preparedStatement.setDate(4, JDBCUtils.getSQLDate(todo.getTargetDate()));
            preparedStatement.setBoolean(5, todo.isDone());
            result = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return result;
    }
}
