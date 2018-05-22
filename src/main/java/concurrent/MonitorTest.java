package concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by changheng on 17/12/13.
 */
public class MonitorTest {

    static class OOMObject{
        public byte[] placeHolder = new byte[64 * 1024];
    }

    public static void fileHeap(int num) throws Exception{
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }

    }

    public static void main(String[] args) throws Exception {
        fileHeap(2000);
        System.gc();
    }
}
