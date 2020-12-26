package JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class updateTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            //创建连接
            //加载JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook?user=root&password=root&useUnicode=true&characterEncoding=UTF-8");
            //创建操作命令
            statement = connection.createStatement();
            //执行SQL语句
            String sql = "update book set price = 61.20 where book.name = '深入理解Java虚拟机'";
            int result = statement.executeUpdate(sql);

            if(result > 0) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                if(statement != null)
                    statement.close();
                if(connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
