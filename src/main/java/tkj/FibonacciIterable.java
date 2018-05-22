package tkj;

import java.util.Iterator;

public class FibonacciIterable implements Iterable<Integer> {
    private int count;
    static private Fibonacci fibonacci;

    public FibonacciIterable(int count) {
        this.count = count;
        this.fibonacci = new Fibonacci();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FiIterator();
    }


    class FiIterator implements Iterator<Integer>{
        @Override
        public boolean hasNext() {
            return count>0;
        }

        @Override
        public Integer next() {
            count--;
            return FibonacciIterable.fibonacci.next();
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        for(int i : new FibonacciIterable(10)){
            System.out.println(i + ",");
        }
    }

}
