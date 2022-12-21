package ShortestPath;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.IndexMinPQ;

public class DijkstraSPImproment1 extends DijkstraShortestPath{
     protected int d;
    public DijkstraSPImproment1() {
        super();
    }

    public DijkstraSPImproment1(EdgeWeightedGraph G, int s, int d) {
        super();
        this.d = d;
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        vGotSP = new boolean[G.V()];
        pq = new IndexMinPQ<>(G.V());

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            if (v == d)
                return;
            vGotSP[v] = true;
            relax(G, v);
        }
    }
    @Override
    public Iterable<Edge> pathTo() {
        return super.pathTo(d);
    }
}
