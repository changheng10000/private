package concurrent;

import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by changheng on 17/11/15.
 */
public class ListTest {

    public void testConcurrentMofication() throws InterruptedException {
        List<String> concurrentList = Collections.synchronizedList(prepareList());


        Thread thread1 = new Thread(()->{
            for (String test: concurrentList){
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(test);
            }
        });
        thread1.start();
        Thread thread = new Thread(()->{
            concurrentList.remove(2);
        });

        thread.start();
        Thread.sleep(60000);
        System.out.println("test");
    }

    private List<String> prepareList(){
        List<String> list = new ArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        return list;
    }
}
