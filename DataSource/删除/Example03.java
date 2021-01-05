package 删除;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example03 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            DataSource ds = new MysqlDataSource();
            ((MysqlDataSource)ds).setUrl("jdbc:mysql://localhost:3306/jdbc?user=root&password=root&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            connection = ds.getConnection();
            String sql = "delete from users where name = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"hh");
            int i = ps.executeUpdate();
            if(i > 0) {
                if(i > 0) {
                    System.out.println("删除成功");
                } else {
                    System.out.println("删除失败");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps != null)
                    ps.close();
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
