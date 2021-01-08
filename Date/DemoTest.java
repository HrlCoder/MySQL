package cn.day23.demo02;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author ：浪漫不死
 * @version:
 * @description：
 * @date : 2020/10/9 16:40
 */

/*
1.使用Scanner类中的方法next获取出生日期
2.使用DateFormat类中的方法parse，把字符串的出生日期解析为Date格式
3.Date格式的出生日期转换为毫秒值
4.获取当前的日期，转换为毫秒值
5.使用当前日期的毫秒值 - 出生日期的毫秒值
6.把毫秒值的差值转换为天（s/1000/60/60/24)

 */
public class DemoTest {
    public static void main(String[] args) throws ParseException {
        //1.使用Scanner类中的方法next获取出生日期
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您得到的出生日期，格式为yyyy-MM-dd");
        String birthDateString = sc.next();
        //2.使用DateFormat类中的方法parse，把字符串的出生日期解析为Date格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDate =  sdf.parse(birthDateString);
        //3.Date格式的出生日期转换为毫秒值
        long birthDateTime = birthDate.getTime();
        //4.获取当前的日期，转换为毫秒值
        long todayTime = new Date().getTime();
        //5.使用当前日期的毫秒值 - 出生日期的毫秒值
        long time = todayTime- birthDateTime;
        //6.把毫秒值的差值转换为天（s/1000/60/60/24)
        System.out.println(time/1000/60/60/24);
    }
}
