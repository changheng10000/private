package concurrent;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by changheng on 17/11/29.
 */
public class SimulatedCAS {
    private int value;

    public synchronized int compareAndSwap(int expectValue, int newValue){
        int oldValue = value;
        if(oldValue == expectValue){
            value = newValue;
        }

        return oldValue;
    }

    public synchronized int get(){
        return value;
    }

    public synchronized boolean compareAndSet(int expectValue, int newValue){
        return expectValue == compareAndSwap(expectValue, newValue);
    }

    public synchronized void setValue(int value){
        this.value = value;
    }

    @org.junit.Test
    public void testCAS() throws InterruptedException {
        SimulatedCAS simulatedCAS = new SimulatedCAS();
        simulatedCAS.setValue(1);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 5000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前线程为:"+Thread.currentThread().getName());
                boolean compareAndSet = simulatedCAS.compareAndSet(1, 5);
                if(compareAndSet){
                    System.out.println("线程:"+Thread.currentThread().getName()+"成功设置");
                }else {
                    System.out.println("线程:"+Thread.currentThread().getName()+"失败设置");
                }
            }).start();
        }

        Thread.sleep(25000);
    }
}
