package concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created by changheng on 17/12/1.
 */
public class BoundedBuffer<E> {
    private final Semaphore availableItems, availbaleSpaces;
    private final E[] items;
    private int putPosition=0, takePosition=0;

    public BoundedBuffer(int capacity){
        availableItems = new Semaphore(0);
        availbaleSpaces = new Semaphore(capacity);
        items = (E[]) new Object[capacity];
    }

    public boolean isEmpty(){
        return availableItems.availablePermits() == 0;
    }

    public boolean isFull(){
        return availbaleSpaces.availablePermits() == 0;
    }

    public void put(E x) throws InterruptedException {
        availbaleSpaces.acquire();
        doInsert(x);
        availableItems.release();
    }

    private synchronized void doInsert(E x) {
        int i = putPosition;
        items[i] = x;
        putPosition = (++i == items.length) ? 0 : i;
    }

    public E take() throws InterruptedException {
        availableItems.acquire();
        E item = doExtract();
        availbaleSpaces.release();
        return item;
    }

    private synchronized E doExtract() {
        int i = takePosition;
        E x = items[i];
        items[i] = null;
        takePosition = (++i == items.length) ? i : i;
        return x;
    }

}
