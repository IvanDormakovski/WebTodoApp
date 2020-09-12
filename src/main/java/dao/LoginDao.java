package main.java.dao;

import main.java.model.LoginBean;
import main.java.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    public boolean validate(LoginBean loginBean) {
        String SELECT_USERNAME = "SELECT * FROM users WHERE username = ? and password = ?";
        boolean status = false;

        try (Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERNAME)) {
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USERNAME);
            preparedStatement.setString(1, loginBean.getUserName());
            preparedStatement.setString(2, loginBean.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.next();
        } catch (SQLException e) {
            JDBCUtils.printSQLException(e);
        }
        return status;
    }
}
