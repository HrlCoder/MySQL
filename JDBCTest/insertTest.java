package JDBCTest;

import java.sql.*;


public class insertTest {
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
            String sql = "insert into borrow_info values (19,10,3,'2019-09-25 17:50:00','2019-10-25 17:50:00')";
            int result = statement.executeUpdate(sql);

            if(result > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
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