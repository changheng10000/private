package concurrent;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by changheng on 17/11/17.
 */
public class BoundedSetTest<T> {
    private final Set<T> set;
    private final Semaphore sem;

    public BoundedSetTest(int bounds){
        set = Collections.synchronizedSet(new HashSet<>());
        sem = new Semaphore(bounds);
    }

    public void add(T o) throws InterruptedException {
        System.out.println("开始获取许可");
        sem.acquire();
        boolean isAdd = false;
        try{
            isAdd = set.add(o);
        }finally {
            if(!isAdd){
                sem.release();
            }
        }
    }

    public boolean remove(T o){
        boolean isRemove = set.remove(o);
        if(isRemove){
            sem.release();
        }

        return isRemove;
    }


    public static void main(String[] args) throws InterruptedException {
        BoundedSetTest<String> boundedSetTest = new BoundedSetTest<>(5);
        for (int i = 0; i < 6; i++) {
            int finalI = i;
            Thread thread = new Thread(()->{
                try {
                    System.out.println("开始添加元素"+finalI);
//                    Thread.sleep(5000);
                    boundedSetTest.add("test"+ finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("启动线程"+finalI);
            thread.start();

        }
        Thread.sleep(10000);
        System.out.println(boundedSetTest.set);

//        boundedSetTest.remove("test1");


        Thread.sleep(5000);
        System.out.println(boundedSetTest.set);

    }
}
