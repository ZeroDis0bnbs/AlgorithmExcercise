package test;

import UnionFind.QuickFind;
import UnionFind.QuickUnion;
import UnionFind.WeightedQuickUnion;

public class Percolation {
    private int N;
    private int choice;
    private boolean[] sites;
    private QuickFind QF;
    private QuickUnion QU;
    private WeightedQuickUnion WQU;

    public Percolation(int n, int choiceUF) {
        if (n < 1 || choiceUF < 1 || choiceUF > 3)
            throw new IllegalArgumentException("非法参数");
        N = n;
        choice = choiceUF; 
        sites = new boolean[N * N + 2];
        sites[0] = true;
        sites[N * N + 1] = true;
        QF = new QuickFind(N * N + 2);
        QU = new QuickUnion(N * N + 2);
        WQU = new WeightedQuickUnion(N * N + 2);
    }

    public void open(int row, int col) {
        int site = N * (row - 1) + col;
        int up = site - N, down = site + N, left = site - 1, right = site + 1; 
        if (row < 1 || row > N || col < 1 || col > N) 
            throw new IndexOutOfBoundsException("坐标越界");
        if (sites[site])
            return;
        sites[site] = true;
        
        if (choice == 1) {
            if (row == 1)
                QF.union(0, site);
            if (row == N)
                QF.union(site, N * N + 1);

            if (row != 1 && sites[up])
                QF.union(site, up);
            if (row != N && sites[down])
                QF.union(site, down);
            if (col != 1 && sites[left])
                QF.union(site, left);
            if (col != N && sites[right])
                QF.union(site, right);
        } else if (choice == 2) {
            if (row == 1)
                QU.union(0, site);
            if (row == N)
                QU.union(site, N * N + 1);

            if (row != 1 && sites[up])
                QU.union(site, up);
            if (row != N && sites[down])
                QU.union(site, down);
            if (col != 1 && sites[left])
                QU.union(site, left);
            if (col != N && sites[right])
                QU.union(site, right);        
        } else {
            if (row == 1)
                WQU.union(0, site);
            if (row == N)
                WQU.union(site, N * N + 1);

            if (row != 1 && sites[up])
                WQU.union(site, up);
            if (row != N && sites[down])
                WQU.union(site, down);
            if (col != 1 && sites[left])
                WQU.union(site, left);
            if (col != N && sites[right])
                WQU.union(site, right);      
        }
    }

    public boolean isOpen(int row, int col) {
        if (row < 1 || row > N || col < 1 || col > N) 
            throw new IndexOutOfBoundsException("坐标越界");

        return sites[(row - 1) * N + col];
    }

    public boolean isFull(int row, int col) {
        if (row < 1 || row > N || col < 1 || col > N) 
            throw new IndexOutOfBoundsException("坐标越界");
        
        if (choice == 1)
            return QF.connected(N * (row - 1) + col, 0);
        else if (choice == 2)
            return QU.connected(N * (row - 1) + col, 0);
        else  
            return WQU.connected(N * (row - 1) + col, 0);
    }

    public boolean percolates() {
        if (choice == 1)
            return QF.connected(0, N * N + 1);
        else if (choice == 2)
            return QU.connected(0, N * N + 1);
        else 
            return WQU.connected(0, N * N + 1);
    }
}