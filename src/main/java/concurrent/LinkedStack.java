package concurrent;

/**
 * 堆栈(LIFO)
 * @param <T>
 */
public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end(){
            return item==null && next==null;
        }
    }

    Node<T> top = new Node<>();//末端哨兵

    public void push(T item){
        top = new Node<>(item, top);
    }

    public T pop(){
        T res = top.item;
        if(!top.end()){
            top = top.next;
        }

        return res;
    }
    public <T> void item(){
        System.out.println("item");
    }

    public static void main(String[] args) {
        LinkedStack<String> ls = new LinkedStack<>();
        for(String s : "This is a beautiful world!".split(" ")){
            ls.push(s);
        }

        String ps;
        while((ps=ls.pop()) != null){
            System.out.println(ps);
        }
    }
}
