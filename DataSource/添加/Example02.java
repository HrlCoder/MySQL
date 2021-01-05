package 添加;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Example02 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            DataSource ds = new MysqlDataSource();
            ((MysqlDataSource)ds).setUrl("jdbc:mysql://localhost:3306/jdbc?user=root&password=root&useUnicode=true&characterEncoding=UTF-8&useSSL=false");

            connection = ds.getConnection();
            String sql = "insert into users(name,password,email,birthday) values(?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"hh");
            ps.setString(2,"123456");
            ps.setString(3,"hh@sina.com");
            ps.setString(4,"1978-12-04");
            int i = ps.executeUpdate();
            if(i > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
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
