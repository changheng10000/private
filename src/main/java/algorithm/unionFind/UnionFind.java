package algorithm.unionFind;

/**
 *
 */
public abstract class UnionFind {
    abstract int count();

    abstract int find(int p);

    abstract void union(int p, int q);

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
}
