package concurrent;

import org.junit.*;
import org.junit.Test;

/**
 * Created by changheng on 17/12/1.
 */
public class BoundedBufferTest {
    @org.junit.Test
    public void testIsEmptyWhenConstructed(){
        BoundedBuffer<Integer> integerBoundedBuffer = new BoundedBuffer<Integer>(10);
        Assert.assertTrue(integerBoundedBuffer.isEmpty());
        Assert.assertFalse(integerBoundedBuffer.isFull());
    }

    @Test
    public void testIsFullAfterPuts() throws InterruptedException {
        BoundedBuffer<Integer> integerBoundedBuffer = new BoundedBuffer<Integer>(10);
        for (int i = 0; i < 10; i++) {
            integerBoundedBuffer.put(i);
        }
        Assert.assertTrue(integerBoundedBuffer.isFull());
        Assert.assertFalse(integerBoundedBuffer.isEmpty());
    }
}
