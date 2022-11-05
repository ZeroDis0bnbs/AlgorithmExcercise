package UnionFind;

public class QuickUnion {
    private int[] id;

    public QuickUnion(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public int find(int p) {
        while (p != id[p]) 
            p = id[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return find(p) == find (q);
    }

    public void union(int p, int q) {   
        int pRoot = find(p), qRoot = find(q);
        if (pRoot == qRoot)
            return;
            
        id[pRoot] = qRoot;
    }
}
