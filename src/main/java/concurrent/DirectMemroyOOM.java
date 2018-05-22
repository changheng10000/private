package concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by changheng on 17/12/8.
 */
public class DirectMemroyOOM {
    private static final int _1MB = 1024 * 1024 * 1024;

    public static void main(String[] args) throws Exception{
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            System.out.println("开始分配内存");
            unsafe.allocateMemory(_1MB);
        }
    }
}
