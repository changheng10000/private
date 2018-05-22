package concurrent;

/**
 * Created by changheng on 18/1/10.
 */
public class StaticDispatch {
    static abstract class Human{}
    static class Man extends Human{}
    static class Woman extends Human{}

    public void hello(Human human){
        System.out.println("human");
    }

    public void hello(Man man){
        System.out.println("man");
    }

    public void hello(Woman woman){
        System.out.println("woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.hello(man);
        staticDispatch.hello(woman);
    }
}
