package concurrent;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SimpleComparator implements Comparator<Item> {

    public int compare(Item o1, Item o2) {
        return o1.getPrice() - o2.getPrice();
    }

    public static void main(String[] args) {
//        List<Item> items = Arrays.asList(new Item("banana", 200), new Item("apple", 400), new Item("Orange", 100));
//        Collections.sort(items, new SimpleComparator());
//        System.out.println(items);

//        Collections.sort(items, (a, b)->a.getPrice()-b.getPrice());
//        System.out.println(items);


        List<Item> items = Arrays.asList(new Item("banana", 100), new Item("orange", 100), new Item("apple", 400), new Item("orange", 50));
        items.sort((Item a, Item b) -> a.getPrice() - b.getPrice());
        System.out.println(items);
        //使用上面的thenComparing
        items.sort(Comparator.comparing(Item::getName).thenComparing(Item::getPrice));
        System.out.println("after using thenComparing: " + items);
    }
}
