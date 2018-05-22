package concurrent;

/**没有使用同步确保holder对象对其他线程可见,
 * Created by changheng on 17/11/14.
 */
public class Holder {
    private int n;

    public Holder(int n) throws InterruptedException {
        this.n = n;
        Thread.sleep(5000);
    }

    public void assertSanity(){
        if(n != n){
            throw new AssertionError("This statement is false.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Holder[] holder = {null};
        Thread init = new Thread(()->{
            try {
                holder[0] = new Holder(1);//未被正确发布
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        init.start();
        Thread thread = new Thread(() -> {
            holder[0].assertSanity();//可能看到holder[0]是一个失效值
        });
        thread.start();
    }
}
