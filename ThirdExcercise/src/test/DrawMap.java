package test;

import ShortestPath.*;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Iterator;
import java.util.Scanner;

public class DrawMap {
    public static Maps maps = new Maps();

    public static void drawMap() {
        StdDraw.setPenColor(StdDraw.BLACK);
        for (Edge edge : maps.getGraph().edges()) {
            int v1 = edge.either();
            int v2 = edge.other(v1);
            StdDraw.line(maps.getCorX(v1), maps.getCorY(v1), maps.getCorX(v2), maps.getCorY(v2));
        }
    }

    public static void drawRoute(Iterable<Edge> route) {
        StdDraw.setPenColor(StdDraw.RED);
        Iterator<Edge> edges = route.iterator();
        while (edges.hasNext()) {
            Edge next = edges.next();
            System.out.println(next);
            int v1 = next.either();
            int v2 = next.other(v1);
            StdDraw.line(maps.getCorX(v1), maps.getCorY(v1), maps.getCorX(v2), maps.getCorY(v2));
        }

    }

    public static void drawScanRegion(DijkstraShortestPath djSP) {
        StdDraw.setPenColor(StdDraw.YELLOW);
        for (int i = 0; i < maps.getGraphV(); i++) {
            if (djSP.gotSP(i)) {
                for (Edge edge : maps.getGraph().adj(i)) {
                    int v1 = edge.either();
                    int v2 = edge.other(v1);
                    StdDraw.line(maps.getCorX(v1), maps.getCorY(v1), maps.getCorX(v2), maps.getCorY(v2));
                }
            }
        }
    }

    public static EdgeWeightedGraph getGraph() {
        return maps.getGraph();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int d = sc.nextInt();
        int choice = sc.nextInt();
        DijkstraShortestPath djSP;

        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setPenRadius(0.001);
        StdDraw.setXscale(0, 10000);
        StdDraw.setYscale(0, 5000);
        drawMap();
        if (choice == 0) {
            djSP = new DijkstraShortestPath(getGraph(), s);
            drawScanRegion(djSP);
            drawRoute(djSP.pathTo(d));
        } else if (choice == 1) {
            djSP = new DijkstraSPImproment1(getGraph(), s, d);
            drawScanRegion(djSP);
            drawRoute(djSP.pathTo());
        } else if (choice == 2) {
            djSP = new DijkstraSPImproment2(getGraph(), s, d);
            drawScanRegion(djSP);
            drawRoute(djSP.pathTo());
        } else if (choice == 3) {
            djSP = new DijkstraSPImproment3(getGraph(), s, d);
            drawScanRegion(djSP);
            drawRoute(djSP.pathTo());
        }
    }
}
