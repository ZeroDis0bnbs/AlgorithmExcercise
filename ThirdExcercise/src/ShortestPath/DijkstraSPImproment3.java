package ShortestPath;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.IndexMultiwayMinPQ;
import test.Maps;

public class DijkstraSPImproment3 extends DijkstraSPImproment2{
    protected IndexMultiwayMinPQ<Double> mulPQ;

    public DijkstraSPImproment3(EdgeWeightedGraph G, int s, int d) {
        super();
        this.d = d;
        vGotSP = new boolean[G.V()];
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        mulPQ = new IndexMultiwayMinPQ<>(G.V(), 2);

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        mulPQ.insert(s, 0.0);
        while (!mulPQ.isEmpty()) {
            int v = mulPQ.delMin();
            if (v == d)
                return;
            vGotSP[v] = true;
            relax(G, v);
        }
    }

    @Override
    protected void relax(EdgeWeightedGraph G, int v) {
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (distTo[w] - 0.000001 > distTo[v] + e.weight() + Maps.distance(w, d) - Maps.distance(v, d)) {
                distTo[w] = distTo[v] + e.weight() + Maps.distance(w, d) - Maps.distance(v, d);
                edgeTo[w] = e;
                if (mulPQ.contains(w))
                    mulPQ.changeKey(w, distTo[w]);
                else
                    mulPQ.insert(w, distTo[w]);
            }
        }
    }

    @Override
    public Iterable<Edge> pathTo() {
        return super.pathTo();
    }
}
