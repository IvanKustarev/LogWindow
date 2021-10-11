package LogWindow.DBWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private Connection connection;

    private String url = "jdbc:postgresql://localhost:8999/studs";
    private String user = "s309681";
    private String password = "yvr557";

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
