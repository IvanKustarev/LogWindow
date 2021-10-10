package LogWindow.DBWork;

import java.sql.SQLException;
import java.util.Collection;

public interface DBWorking {
    public void pushNewUser(UserWithSalt user) throws SQLException;
    public UserWithSalt getUser(String name) throws SQLException;
}

