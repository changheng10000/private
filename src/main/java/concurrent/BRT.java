package concurrent;

//红黑树
public class BRT<KEY extends Comparable, VALUE> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node{
        private Node left;
        private Node right;
        private boolean color;
        //包括该节点和该节点以下所有的节点数
        private int N;

        private KEY key;
        private VALUE value;

        Node(KEY key, VALUE value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node x){
        if (x == null){
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node h){

        return null;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    public void put(KEY key, VALUE value){
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node x, KEY key, VALUE value) {
        if(x == null){
            return new Node(key, value, 1, RED);
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = put(x.left, key, value);
        }else if(cmp > 0){
            x.right = put(x.right, key, value);
        }else{
            x.value =value;
        }

        if(isRed(x.right) && !isRed(x.left)){
            rotateLeft(x);
        }else if(isRed(x.left) && isRed(x.left.left)){
            rotateRight(x);
        }else if(isRed(x.left) && isRed(x.right)){
            flipColor(x);
        }

        x.N = size(x.left) + size(x.right) + 1;
        return null;
    }

    private void flipColor(Node h){
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    private int size(Node x){
        if (x == null){
            return 0;
        }

        return x.N;
    }

}
