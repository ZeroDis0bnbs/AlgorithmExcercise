package test;

import java.util.Scanner;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
    private int sideLength;
    private double meanVal,stddevVal,confidenceLoVal,confidenceHiVal;
    private double[] pr;
    
    public PercolationStats(int N, int T, int choice) {
        if (N < 1 || T < 0)
            throw new IllegalArgumentException("非法参数");
        
        sideLength = N;
        pr = new double[T];
        for (int i = 0; i < T; i++) {
            Percolation percolation = new Percolation(sideLength, choice);
            int cnt = 0;
            while (!percolation.percolates()){
                int row = StdRandom.uniform(sideLength) + 1, col = StdRandom.uniform(sideLength) + 1;
                if (!percolation.isOpen(row, col)) {
                    percolation.open(row, col);
                    cnt++;
                }    
            }
            pr[i] = cnt * 1.0 / (sideLength * sideLength);
        }

        meanVal = StdStats.mean(pr);
        stddevVal = StdStats.stddev(pr);
        confidenceLoVal = meanVal - (1.96 * stddevVal) / Math.sqrt(T);
        confidenceHiVal = meanVal + (1.96 * stddevVal) / Math.sqrt(T);
    }

    public double mean() {
        return meanVal;
    }

    public double stddev() {
        return stddevVal;
    }

    public double confidenceLo() {
        return confidenceLoVal;
    }

    public double confidenceHi() {
        return confidenceHiVal;
    }

    public static void main(String[] args) {
        int n, T, choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入边长:");
        n = sc.nextInt();
        System.out.println("请输入实验次数:");
        T = sc.nextInt();
        System.out.println("请选择UF算法(QF-1,QU-2,WQU-3):");
        choice = sc.nextInt();
        long startTime = System.currentTimeMillis();
        PercolationStats percolationStats = new PercolationStats(n, T, choice);
        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println("渗透阈值的平均值:" + percolationStats.mean()); 
        System.out.println("渗透阈值的样本标准差:" + percolationStats.stddev());
        System.out.println("95%置信区间下限:" + percolationStats.confidenceLo());
        System.out.println("95%置信区间上限:" + percolationStats.confidenceHi());
        System.out.println("总花费时间为:" + totalTime + "ms");
    }
}
