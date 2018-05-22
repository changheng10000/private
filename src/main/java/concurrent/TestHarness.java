package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by changheng on 17/11/17.
 */
public class TestHarness {

    public long timeTasks(int nThreads, Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread(()->{
                try {
                    System.out.println("等待开门");
                    startGate.await();

                    try{
                        System.out.println("开始执行");
                        task.run();
                        System.out.println("结束执行");
                    }finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }

        long startTime = System.nanoTime();
        System.out.println("开门");
        startGate.countDown();
        endGate.await();
        long endTime = System.nanoTime();
        return endTime - startTime;

    }

    public static void main(String[] args) throws Exception {
        TestHarness testHarness = new TestHarness();
        Runnable task = ()->{
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(1000,5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        long l = testHarness.timeTasks(10, task);
        System.out.println("方法执行时间为:"+l);
    }
}
