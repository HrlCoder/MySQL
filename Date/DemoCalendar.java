package cn.day23.demo02;

import java.util.Calendar;
import java.util.Date;

/**
 * @author ：浪漫不死
 * @version:
 * @description：
 * @date : 2020/10/9 16:59
 */
public class DemoCalendar {
    public static void main(String[] args) {
//        Calendar c = Calendar.getInstance();    //多态
//        System.out.println(c);

        demo01();
        System.out.println("========");
        demo02();
        System.out.println("========");
        demo03();
        System.out.println("========");
        demo04();

    }

    private static void demo04() {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        System.out.println(date);
    }

    private static void demo03() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR,2);
        c.add(Calendar.MONTH,-3);
    }

    private static void demo02() {

        Calendar c = Calendar.getInstance();

        c.set(Calendar.YEAR,9999);
        c.set(Calendar.MONTH,9);
        c.set(Calendar.DATE,9);

        c.set(2020,10,9);

        int year = c.get(Calendar.YEAR);
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month);

        int day = c.get(Calendar.DATE);
        System.out.println(day);
    }

    private static void demo01() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        System.out.println(year);

        int month = c.get(Calendar.MONTH);
        System.out.println(month);

        int day = c.get(Calendar.DATE);
        System.out.println(day);
    }
}
