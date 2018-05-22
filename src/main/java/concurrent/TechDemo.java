package concurrent;

import org.junit.*;

/**
 * Created by changheng on 18/1/4.
 */
public class TechDemo {
    public static void main(String[] args) {
        System.out.println("Hello dsp!");

        System.out.printf("%x\n", 2129);

//        aMethod();
    }
    @org.junit.Test
    public void test(){
        System.out.println(this.getClass().getTypeName());
    }

    private static String getExecutingMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement e = stackTrace[2];
        return e.getMethodName();
    }

    private static void aMethod() {
        System.out.println("######### aMethod #########");
        //String executingMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        String executingMethodName = getExecutingMethodName();
        System.out.println(executingMethodName);
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        System.out.println(className);
        String fileName = Thread.currentThread().getStackTrace()[2].getFileName();
        System.out.println(fileName);
        System.out.println("******** aMethod ******");

        bMethod();
    }

    private static void bMethod() {
        System.out.println("######### bMethod #########");
        // String executingMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        String executingMethodName = getExecutingMethodName();
        System.out.println(executingMethodName);
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        System.out.println(className);
        String fileName = Thread.currentThread().getStackTrace()[2].getFileName();
        System.out.println(fileName);
        System.out.println("******** bMethod ******");

        cMethod();
    }

    private static void cMethod() {
        System.out.println("######### cMethod #########");
        String executingMethodName = getExecutingMethodName();
        System.out.println(executingMethodName);
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        System.out.println(className);
        String fileName = Thread.currentThread().getStackTrace()[2].getFileName();
        System.out.println(fileName);

        saveA();
        updateB();

        System.out.println("******** cMethod ******");
    }

    public static void saveA() {
        System.out.println("######### saveA #########");
        // ###
        String executingMethodName = getExecutingMethodName();
        System.out.println(executingMethodName);

        // ###
        String name = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println(name);
        System.out.println("******** saveA ******");
    }

    public static void updateB() {
        System.out.println("######### updateB #########");
        String executingMethodName = getExecutingMethodName();
        System.out.println(executingMethodName);
        System.out.println("******** updateB ******");
    }
}
