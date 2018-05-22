package concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by changheng on 17/12/7.
 */
public class HeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
