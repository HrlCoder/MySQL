package 修改;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example04 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            DataSource ds = new MysqlDataSource();
            ((MysqlDataSource)ds).setUrl("jdbc:mysql://localhost:3306/jdbc?user=root&password=root&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            connection = ds.getConnection();
            String sql = "update users set birthday = '1997-12-14' where name = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"zs");
            int i = ps.executeUpdate();
            if(i > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
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
