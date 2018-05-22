package tkj;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int size){
        array = (T[])Array.newInstance(type, size);
    }

    public void put(int index, T item){
        array[index] = item;
    }

    public T get(int index){
        return array[index];
    }

    public T[] rep(){
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> token = new GenericArrayWithTypeToken<>(Integer.class, 10);
        token.put(5,10);
        token.put(1,6);
        Integer[] rep = token.rep();
        System.out.println(Arrays.toString(rep));
    }
}
