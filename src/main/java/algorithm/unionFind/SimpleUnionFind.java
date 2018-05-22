package algorithm.unionFind;

public class SimpleUnionFind extends UnionFind {
    private int count;//分量的个数
    private int[] index;

    public SimpleUnionFind(int N){
        this.count = N;
        index = new int[N];
        for (int i = 0; i < N; i++) {
            index[i] = i;
        }
    }

    @Override
    int count() {
        return count;
    }

    @Override
    int find(int p) {
        return index[p];
    }

    @Override
    void union(int p, int q) {
        int pV = index[p];
        int qV = index[q];

        if(pV == qV){
            return;
        }

        for (int i = 0; i < index.length; i++) {
            if(index[i] == pV){
                index[i] = qV;
            }
        }

        count--;
    }

    public static void main(String[] args) {
        int[] unions = new int[]{4, 3, 3, 8, 6, 5, 9, 4, 2, 1, 8, 9, 5, 0, 7, 2, 6, 1, 1, 0, 6, 7};
        int n = unions.length;
        SimpleUnionFind unionFind = new SimpleUnionFind(10);
        for (int i = 0; i < n; i+=2) {
            int p = unions[i];
            int q = unions[i+1];
            if(unionFind.connected(p, q)){
                continue;
            }
            unionFind.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(unionFind.count() + "components");
    }
}
