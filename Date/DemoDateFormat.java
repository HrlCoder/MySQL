package cn.day23.demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：浪漫不死
 * @version:
 * @description：
 * @date : 2020/10/8 21:59
 */
public class DemoDateFormat {
    public static void main(String[] args) throws ParseException {
        demo01();

    }

    private static void demo02() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date = sdf.parse("2020年10月09日 16时38分05秒");
        System.out.println(date);
    }

    private static void demo01() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date = new Date();
        String d = sdf.format(date);
        System.out.println(d);
    }
}
