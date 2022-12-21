package ShortestPath;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.IndexMinPQ;
import test.Maps;

public class DijkstraSPImproment2 extends DijkstraSPImproment1 {
    public DijkstraSPImproment2() {
        super();
    }

    public DijkstraSPImproment2(EdgeWeightedGraph G, int s, int d) {
        super(G, s, d);
    }

    @Override
    protected void relax(EdgeWeightedGraph G, int v) {
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (distTo[w] - 0.000001 > distTo[v] + e.weight() + Maps.distance(w, d) - Maps.distance(v, d)) {
                distTo[w] = distTo[v] + e.weight() + Maps.distance(w, d) - Maps.distance(v, d);
                edgeTo[w] = e;
                if (pq.contains(w))
                    pq.changeKey(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
            }
        }
    }

    @Override
    public Iterable<Edge> pathTo() {
        return super.pathTo();
    }
}
