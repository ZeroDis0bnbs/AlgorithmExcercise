package UnionFind;

public class QuickFind {
    private int[] id;

    public QuickFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) 
            id[i] = i;
    }

    public int find(int p) {
        return id[p];
    }

    public boolean connected (int p, int q) {
        return id[p] == id[q];
    }

    public void union (int p, int q) {
        int pId = id[p], qId = id[q];
        if (pId == qId)
            return;

        for (int i = 0; i < id.length; i++)
            if (pId == id[i])
                id[i] = qId;
    }
}