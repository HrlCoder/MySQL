package cn.day23.demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ����������
 * @version:
 * @description��
 * @date : 2020/10/8 21:59
 */
public class DemoDateFormat {
    public static void main(String[] args) throws ParseException {
        demo01();

    }

    private static void demo02() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
        Date date = sdf.parse("2020��10��09�� 16ʱ38��05��");
        System.out.println(date);
    }

    private static void demo01() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
        Date date = new Date();
        String d = sdf.format(date);
        System.out.println(d);
    }
}
