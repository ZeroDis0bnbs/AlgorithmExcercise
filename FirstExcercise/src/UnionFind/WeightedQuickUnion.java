package UnionFind;

public class WeightedQuickUnion {
    private int[] id;
    private int[] size;

    public WeightedQuickUnion(int N) {
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p) {
        while (p != id[p]) 
            p = id[p];
        return p;
    }
    
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p), qRoot = find(q);
        if (pRoot == qRoot)
            return;

        if (size[p] < size[q]) {
            size[q] += size[p];
            id[pRoot] = qRoot;
        } else {
            size[p] += size[q];
            id[qRoot] = pRoot;
        }
    }
}