package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by changheng on 17/11/24.
 */
public class TimingThreadPoolTest {
    @org.junit.Test
    public void test() throws Exception{
        TimingThreadPool timingThreadPool = new TimingThreadPool(5, 10, 5000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i < 5; i++) {
//            Future<String> submit = timingThreadPool.submit(new TimingCallable());
            timingThreadPool.execute(new TimingRunnable());
//            System.out.println("第"+i+"个任务的结果是" + submit.get());

        }

        timingThreadPool.shutdown();
        timingThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    private class TimingCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 5000));
            System.out.println("正在运行" + Thread.currentThread().getName());
            return Thread.currentThread().getName();
        }
    }

    private class TimingRunnable implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 5000));
                System.out.println("正在运行" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
