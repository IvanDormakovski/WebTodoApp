package main.java.model;

import java.time.LocalDate;
import java.util.Objects;

public class Todo {
    private static final long serialVersionUID = 1L;
    private long id;
    private String userName;
    private String title;
    private String description;
    private LocalDate targetDate;
    private boolean isDone;

    public Todo(long id, String userName, String title, String description, LocalDate targetDate, boolean isDone) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public Todo(String userName, String title, String description, LocalDate targetDate, boolean isDone) {
        this.userName = userName;
        this.title = title;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo)) return false;
        Todo todo = (Todo) o;
        return getId() == todo.getId() &&
                isDone() == todo.isDone() &&
                Objects.equals(getUserName(), todo.getUserName()) &&
                Objects.equals(getTitle(), todo.getTitle()) &&
                Objects.equals(getDescription(), todo.getDescription()) &&
                Objects.equals(getTargetDate(), todo.getTargetDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getTitle(), getDescription(), getTargetDate(), isDone());
    }
}
