package main.java.dao;

import main.java.model.Todo;

import java.util.List;

public interface TodoDao {
    void insertTodo(Todo todo);
    Todo selectTodo(long todoId);
    List<Todo> selectAllTodos();
    boolean deleteTodo(long todoId);
    boolean updateTodo(Todo todo);
}
