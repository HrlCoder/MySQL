package 查询;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class Example01 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Borrow> list = new ArrayList<>();
        //注册数据库驱动
        try {
            //写法一
            DataSource ds = new MysqlDataSource();
            ((MysqlDataSource)ds).setUrl("jdbc:mysql://localhost:3306/ebook?user=root&password=root&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            connection = ds.getConnection();
            //写法二
//            Class.forName("com.mysql.jdbc.Driver");
//            //获取数据库连接
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook?user=root&password=root&useUnicode=true&characterEncoding=UTF-8&useSSL=false");

            statement = connection.createStatement();
            String sql = "select name,author,price from book";
            resultSet= statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                Double price = resultSet.getDouble("price");
                System.out.printf(String.format("查询.Borrow:book=%s,author=%s,price=%s%n",name,author,price));

                Borrow b = new Borrow();
                b.setName(name);
                b.setAuthor(author);
                b.setPrice(price);
                list.add(b);
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
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
    private String name;
    private String author;
    private double price;

    @Override
    public String toString() {
        return "查询.Borrow{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}