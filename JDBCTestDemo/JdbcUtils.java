package JDBCTestDemo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/servlet_blog?" +
            "user=root&password=root&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static final DataSource DS = new MysqlDataSource();

    static {
        ((MysqlDataSource)DS).setUrl(URL);
    }

    public static Connection getConnection() throws SQLException {
            return DS.getConnection();
    }

    public static void close(Connection c, Statement s) {
        close(c,s,null);
    }

    public static void close(Connection c, Statement s, ResultSet r) {
        try {
            if(r != null)
                r.close();
            if(s != null)
                s.close();
            if(c != null)
                c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
