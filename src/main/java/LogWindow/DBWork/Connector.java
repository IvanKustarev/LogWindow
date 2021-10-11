package LogWindow.DBWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private Connection connection;

//    Здесь нужно ввести URL БД и имя пользователя с паролём jdbc:postgresql://localhost:8999/studs
//    Если Имя пользователя и пароля нет, то поставить вместо строк null
    private String url = "...";
    private String user = "...";
    private String password = "...";

    public Connection connect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user == null){
            connection = DriverManager.getConnection(url);
        }else {
            connection = DriverManager.getConnection(url, user, password);
        }
        try {
            connection.setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
    public Connection getConnection() {
        return connection;
    }
}
