package ShortestPath;

import edu.princeton.cs.algs4.*;

public class DijkstraShortestPath {
    protected Edge[] edgeTo;
    protected boolean[] vGotSP;
    protected double[] distTo;
    protected IndexMinPQ<Double> pq;

    public DijkstraShortestPath() {
    }

    public DijkstraShortestPath(EdgeWeightedGraph G, int s) {
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
            vGotSP[v] = true;
            relax(G, v);
        }

    }

    protected void relax(EdgeWeightedGraph G, int v) {
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (distTo[w] > distTo[v] + e.weight()) {
               distTo[w] = distTo[v] + e.weight();
               edgeTo[w] = e;
               if (pq.contains(w))
                   pq.changeKey(w, distTo[w]);
               else
                   pq.insert(w, distTo[w]);
            }
        }
    }


    public double distTo(int v) {
        return distTo[v];
    }
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<Edge> pathTo(int v) {
        if(!hasPathTo(v))
                return null;
        Stack<Edge> path = new Stack<>();
        int w = v;
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[w] ) {
            path.push(e);
            w = e.other(w);
        }
        return path;
    }

    public Iterable<Edge> pathTo() {
        return null;
    }

    public Edge[] edgeTo() {
        return edgeTo;
    }

    public boolean gotSP(int v) {
        return vGotSP[v];
    }
}
