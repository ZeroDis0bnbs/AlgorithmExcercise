package test;

import ShortestPath.DijkstraSPImproment1;
import ShortestPath.DijkstraSPImproment3;
import ShortestPath.DijkstraShortestPath;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.StdDraw;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Maps {
    private static int[][] crd;
    private static EdgeWeightedGraph G;

    public Maps() {
        String string = "ThirdExcercise\\usa.txt";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner sc = new Scanner(new BufferedInputStream(fis));
        int V = sc.nextInt();
        int E = sc.nextInt();

        G = new EdgeWeightedGraph(V);
        crd = new int[V][2];
        for (int i = 0; i < V; i++) {
            int v = sc.nextInt();
            crd[v][0] = sc.nextInt();
            crd[v][1] = sc.nextInt();
        }

        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            Edge e = new Edge(v1, v2, distance(v1, v2));
            G.addEdge(e);
        }
        sc.close();
    }
    public static double distance(int v1,int v2) {
        return Math.sqrt(Math.pow(crd[v1][0] - crd[v2][0], 2) + Math.pow(crd[v1][1] - crd[v2][1], 2));
    }

    public int getCorX(int v) {
        return crd[v][0];
    }

    public int getCorY(int v) {
        return crd[v][1];
    }

    public int getGraphV() {
        return G.V();
    }

    public int getGraphE() {
        return G.E();
    }

    public EdgeWeightedGraph getGraph() {
        return G;
    }

}
