package LogWindow.DBWork;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBWorker implements DBWorking {

    private Connection connection;

    public DBWorker(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void pushNewUser(UserWithSalt user) throws SQLException {
        String sql = "INSERT INTO USERS " +
                "(NAME, PASSWORD, SALT) VALUES ('" + user.getName() + "', '" +
                user.getPassword() + "', '" + user.getSalt() + "');";

        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
        connection.commit();
    }

    @Override
    public UserWithSalt getUser(String name) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS where NAME='" + name + "';");
        resultSet.next();
        UserWithSalt user = new UserWithSalt(resultSet.getString("NAME"), resultSet.getString("PASSWORD"), resultSet.getString("SALT"));
        resultSet.close();
        statement.close();
        return user;
    }
}
