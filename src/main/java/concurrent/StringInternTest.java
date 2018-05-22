package concurrent;

/**
 * Created by changheng on 17/12/8.
 */
public class StringInternTest {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("润建").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja1").append("va").toString();
        System.out.println(str2.intern() == str2);

    }
}
