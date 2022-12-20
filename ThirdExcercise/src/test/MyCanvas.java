package test;

import ShortestPath.DijkstraSPImproment1;
import ShortestPath.DijkstraSPImproment2;
import ShortestPath.DijkstraSPImproment3;
import ShortestPath.DijkstraShortestPath;
import edu.princeton.cs.algs4.Edge;

import java.awt.*;
import java.util.Iterator;

public class MyCanvas extends Canvas {
    private static Graphics g;
    private static Maps maps = new Maps();
    @Override
    public void paint(Graphics g) {
        this.g = g;
        DijkstraShortestPath djSP = new DijkstraSPImproment1(maps.getGraph(), 542, 578);
/*
        g.setColor(Color.BLACK);
        for (Edge edge : maps.getGraph().edges()) {
              int v1 = edge.either();
              int v2 = edge.other(v1);
              g.drawLine(400 + maps.getCorX(v1) / 10,500 - maps.getCorY(v1) / 10,  400 + maps.getCorX(v2) / 10,500 - maps.getCorY(v2) / 10);
        }
        //long startTime = System.nanoTime();
        DijkstraShortestPath djSP = new DijkstraSPImproment1(maps.getGraph(), 542, 578);
        //long endTime = System.nanoTime();
        //long totalTime = endTime - startTime;
        //System.out.println(totalTime);
        for(int i = 0; i < maps.getGraphV(); i++) {
            if (djSP.gotSP(i)) {
                for (Edge edge : maps.getGraph().adj(i)) {
                   // drawPath(edge, Color.YELLOW);
                }
            }
        }
*/

        Iterator<Edge> path = djSP.pathTo().iterator();
        while (path.hasNext()) {
            Edge next = path.next();
            System.out.println(next);
            //drawPath(next, Color.RED);
        }
    }

    private void drawPath(Edge edge, Color color) {
        g.setColor(color);
        int v1 = edge.either();
        int v2 = edge.other(v1);
        g.drawLine(400 + maps.getCorX(v1) / 10,500 - maps.getCorY(v1) / 10,  400 + maps.getCorX(v2) / 10,500 - maps.getCorY(v2) / 10);
    }
}
