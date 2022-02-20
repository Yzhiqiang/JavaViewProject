package com.yu.Date;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 20:28 2022/2/15
 * @Modified By:
 */
public class Date {
    public static void main(String[] args) {
        /**
         获得当前的日期
         */
//        Calendar cal = Calendar.getInstance();
//        System.out.println(cal.get(1));
//        System.out.println(cal.get(2));
//        System.out.println(cal.get(Calendar.DATE));
//        System.out.println(cal.get(Calendar.MINUTE));
//
//        LocalDateTime dt = LocalDateTime.now();
//        System.out.println(dt.getYear());
//        System.out.println(dt.getMonthValue());
//        System.out.println(dt.getDayOfMonth());


        /**
         获取1970年至现在的毫秒数
         */
//        System.out.println(System.currentTimeMillis());
//        System.out.println(Calendar.getInstance().getTimeInMillis());
//        System.out.println(System.currentTimeMillis());
//        System.out.println(Clock.systemDefaultZone().millis());

        /**
         输出当前月的最后一天
         */
//        Calendar cal = Calendar.getInstance();
//        System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));


        /**
         * 格式化时间
         */
//        SimpleDateFormat oldForMatter = new SimpleDateFormat("yyyy/MM/dd");
//        Date date = new Date();
//        System.out.println(oldForMatter.format(date));
//
//        DateTimeFormatter newForMatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        LocalDate date2 = LocalDate.now();
//        System.out.println(newForMatter.format(date2));

        /**
         * 打印昨天的当前时刻
         */
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        System.out.println(cal.getTime());

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yestoday = today.minusDays(1);
        System.out.println(today);
        System.out.println(yestoday);

        Error error = new AbstractMethodError();
        System.out.println(error);
    }
}
