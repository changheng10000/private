package concurrent;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by changheng on 17/11/14.
 */
public class DateTest {

    public static void main(String[] args) {
        Date date = new Date();
//        System.out.println(date.hashCode());
        long time = date.getTime();

        System.out.println(time);
        System.out.println(date);
        time = 1410644453163L;
//        date.setTime(time);
        changeDate(date);
//        System.out.println(date.hashCode());
        System.out.println(date);

        LocalDate localDate = LocalDate.of(2017,11,10);
        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println(dayOfMonth);
        System.out.println(localDate);
    }

    public static void changeDate(Date date){
        date.setTime(1410644453163L);
    }
}
