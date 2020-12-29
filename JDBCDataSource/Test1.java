package JDBCDataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Test1 {
    public static void main(String[] args) {
        query("中文系2019级3班");
    }
    public static List<Student> query(String name1) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Student> list = new ArrayList<>();

        try {
            //创建连接
            //创建数据库连接
            DataSource ds = new MysqlDataSource();
            ((MysqlDataSource) ds).setUrl("jdbc:mysql://localhost:3306/testdemo?user=root&password=root&useUnicode=true&characterEncoding=UTF-8&useSSL=false");

            connection = ds.getConnection();
            //执行SQL语句
            String sql = "select cla.name classes_name,stu.sn,stu.name student_name,cou.name course_name,sco.score " +
                    "from classes cla,student stu,course cou,score sco " +
                    "where cla.id = stu.classes_id " +
                    "and stu.id = sco.student_id " +
                    "and cou.id = sco.course_id " +
                    "and cla.name = ?";//指定占位符
//                    "and cla.name ='"+name1+"'";
            //prepareStatement预编译操作命令对象，注意使用String sql传入参数
            //发送sql，让数据库预编译：语法分析，执行顺序分析，执行优化
            statement = connection.prepareStatement(sql);
            //替换转为负，指定占位符的位置（从1开始），数据类型，
            statement.setString(1,name1);
            //如果执行sql有报错，一定要先打印或者debug看看执行sql语句是否有误
            resultSet = statement.executeQuery();
            //处理结果集
            while (resultSet.next()) {
                String classesName = resultSet.getString("classes_name");
                int sn = resultSet.getInt("sn");
                String studentName = resultSet.getString("student_name");
                String courseName = resultSet.getString("course_name");
                BigDecimal score = resultSet.getBigDecimal("score");
                System.out.printf("classes_name=%s,sn=%s,student_name=%s,course_name=%s,score=%s%n",
                        classesName,sn,studentName,courseName,score);
                Student student = new Student();
                student.setClassName(classesName);
                student.setSn(sn);
                student.setStudentName(studentName);
                student.setCourseName(courseName);
                student.setScore(score);
                list.add(student);
            }
            System.out.println(list);
            return list;
        }catch (Exception e) {
            e.printStackTrace();
            //执行某个功能，如果出现异常，建议再次抛出异常
            throw new RuntimeException("查询班级信息出错了"+e);
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

class Student {
    private String className;
    private int sn;
    private String studentName;
    private String courseName;
    private BigDecimal score;

    @Override
    public String toString() {
        return "Student{" +
                "className='" + className + '\'' +
                ", sn=" + sn +
                ", studentName='" + studentName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", score=" + score +
                '}';
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}
