package thread;

/**
 * Created by changheng on 17/11/10.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;
    private static class ReadThread extends Thread{
        @Override
        public void run() {
            while(!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<1000; i++){
            new ReadThread().start();
            number = 42;
            ready = true;
        }

    }
}
