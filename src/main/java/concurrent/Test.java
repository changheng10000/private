package concurrent;

/**
 * Created by changheng on 17/11/13.
 */
public class Test {
    public static void main(String[] args)  {
        MyClass myClass = new MyClass();
        StringBuffer buffer = new StringBuffer("hello");
        System.out.println("main"+buffer.hashCode());
        myClass.changeValue(buffer);
        System.out.println(buffer.toString());
    }
}

class MyClass {

    void changeValue( StringBuffer buffer) {
        System.out.println("change"+buffer.hashCode());
        buffer = new StringBuffer("world");
        System.out.println("change"+buffer.hashCode());
    }
}

