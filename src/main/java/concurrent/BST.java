package concurrent;

/**
 * 二叉树
 * 1.每个节点有两个子节点
 * 2.每个节点的KEY都是Comparable的
 * 3.对于每一个节点,它的左子树的节点都小于该节点，右子树都大于该节点
 * @param <KEY>
 * @param <VALUE>
 */
public class BST<KEY extends Comparable, VALUE> {
    private Node root;
    private class Node{
        private Node left;
        private Node right;

        //包括该节点和该节点以下所有的节点数
        private int N;
        private KEY key;
        private VALUE value;

        Node(KEY key, VALUE value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    private int size(Node node){
        if(node == null){
            return 0;
        }
        return node.N;
    }

    public void delMin(){
        root = delMin(root);
    }

    /**
     * 删除最小值时需要不断沿着左子树往下走，因为整个树的最小值一定在最左边。所以如果找到一个结点，它的左节点的左节点为空，那么将该节点的右子树赋值给父节点左链接，这样就达到删除的效果，并且更新了最小值。
     * @param x
     * @return
     */
    private Node delMin(Node x) {
        if(x.left == null){
            return x.right;
        }
        x.left = delMin(x.left);

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Node min(){
        return min(root);
    }

    private Node min(Node x) {
        if(x.left == null){
            return x;
        }
        return min(x.left);
    }

    private Node max(Node x){
        if(x.right == null){
            return x;
        }
        return max(x);
    }


    public VALUE get(KEY key){
        return get(root, key);
    }

    private VALUE get(Node x, KEY key) {
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            //左子树查找
            return get(x.left, key);
        }else if(cmp > 0){
            //右子树 查找
            return get(x.right, key);
        }else{
            return x.value;
        }
    }

    public void put(KEY key, VALUE value){
        root = put(root, key, value);
    }

    private Node put(Node x, KEY key, VALUE value) {
        if(x == null){
            //递归重点
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){

            x.left = put(x.left, key, value);
        }else if(cmp > 0){
            x.right = put(x.right, key, value);
        }else{
            x.value = value;
        }

        //同步更新N
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(KEY key){
        root = delete(root, key);
    }

    /**
     * 删除某一个值需要借用delMin()函数。这里用到的删除方法叫做Hibbard方法。
     * 具体思想是当我们查找到一个非叶节点的节点时，在下图中即为点E，
     * 我们要先把E节点的值赋值为他的右子树的最小值，这里即为H，
     * 然后对右子树使用delMin()，也就是删除这个最小值，接着把E节点的左子树赋值给这个新的节点H。
     * 最后向上返回的时候，把H的引用赋值给S这样点E就最终被删除了，新得到的树整体上也是有序的。
     * @param x
     * @param key
     * @return
     */
    private Node delete(Node x, KEY key) {
        if(x == null){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = delete(x.left, key);
        }else if(cmp > 0){
            x.right = delete(x.right, key);
        }else{
            if(x.left == null){
                return x.right;
            }

            if(x.right == null){
                return x.left;
            }
            Node t = x;
            x = min(x.right);
            x.right = delMin(x);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public static void main(String[] args) {
        BST<String, String> bst = new BST<>();
        bst.put("A", "a");
        bst.put("B", "b");
        bst.put("C", "c");
        bst.put("D", "a");
        System.out.println(bst.get("A"));
    }
}
