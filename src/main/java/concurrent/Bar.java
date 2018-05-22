package concurrent;

/**
 * Created by changheng on 17/12/13.
 */
public class Bar {
    int a = 1;
    static int b = 2;

    public int sum(int c){
        return a+b+c;
    }

    public static void main(String[] args) {
        new Bar().sum(3);
    }
}
