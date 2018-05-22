package concurrent;

import java.util.ArrayList;
import java.util.Random;

//随机返回列表中的一个
public class RandomList<T> {
    private final ArrayList<T> store = new ArrayList<>();
    private final Random random = new Random(47);
    public void add(T item){
        store.add(item);
    }

    public T randomSelect(){
        return store.get(random.nextInt(store.size()));
    }

    public int size(){
        return store.size();
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<>();
        for(String s : "Class JavaLaunchHelper is implemented in both".split(" ")){
            randomList.add(s);
        }
        for (int i = 0; i < randomList.size(); i++) {
            System.out.println(randomList.randomSelect());
        }
    }
}
