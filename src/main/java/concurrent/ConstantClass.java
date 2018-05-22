package concurrent;

/**
 * Created by changheng on 17/12/20.
 */
public class ConstantClass {
    static {
        System.out.println("ConstantClass init");
    }
    public static final String HELLO = "hello";
}
