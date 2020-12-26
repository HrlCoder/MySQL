package JDBCTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class selectTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<Borrow> list = new ArrayList<>();

        try {
            //创建连接
            //加载JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建数据库连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook?user=root&password=root&useUnicode=true&characterEncoding=UTF-8");
            //创建操作命令
            statement = connection.createStatement();
            //执行SQL语句
            String sql = "select student.name stu_name,book.name book_name,borrow_info.start_time start_time,borrow_info.end_time end_time from category,book,student,borrow_info where category.id = book.category_id and student.id = borrow_info.student_id and book.id = borrow_info.book_id and category.name = '计算机'";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String stu_name = resultSet.getString("stu_name");
                String book_name = resultSet.getString("book_name");
                Timestamp start_time = resultSet.getTimestamp("start_time");
                Timestamp end_time = resultSet.getTimestamp("end_time");
                System.out.printf(String.format("Borrow:stu_name=%s,book_name=%s,start_time=%s,end_time=%s%n",stu_name,book_name,start_time,end_time));

                Borrow borrow = new Borrow();
                borrow.setStu_name(stu_name);
                borrow.setBook_name(book_name);
                borrow.setStart_time(start_time);
                borrow.setEnd_time(end_time);
                list.add(borrow);
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            try {
                if(resultSet != null)
                    resultSet.close();
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
class Borrow {
    private String stu_name;
    private String book_name ;
    private Timestamp start_time;
    private Timestamp end_time;

    @Override
    public String toString() {
        return "Borrow{" +
                "stu_name='" + stu_name + '\'' +
                ", book_name='" + book_name + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }
}
