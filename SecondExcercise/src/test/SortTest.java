package test;

import Sort.*;
import edu.princeton.cs.algs4.StdStats;
import java.util.Random;
import java.util.Scanner;


public class SortTest {
    private static int[] datas;
    private static double[][] times = new double[5][10];
    private static double[] aveTimes = new double[5];

    public SortTest(int num, int choice) {
        datas = new int[num];
        int[] buff = new int[num];
        randomData(datas, num, choice);

        for (int i = 0; i < 10; i++) {
            System.arraycopy(datas, 0, buff, 0, num);
            long startTime = System.nanoTime();
            InsertionSort insertionSort = new InsertionSort(buff);
            long endTime = System.nanoTime();
            times[0][i] = (endTime - startTime) * 1.0 / 1000000;

            System.arraycopy(datas, 0, buff, 0, num);
            startTime = System.nanoTime();
            TopDownMergeSort topDownMergeSort = new TopDownMergeSort(buff);
            endTime = System.nanoTime();
            times[1][i] = (endTime - startTime) * 1.0 / 1000000;

            System.arraycopy(datas, 0, buff, 0, num);
            startTime = System.nanoTime();
            BottomUpMergeSort bottomUpMerge = new BottomUpMergeSort(buff);
            endTime = System.nanoTime();
            times[2][i] = (endTime - startTime) * 1.0 / 1000000;

            System.arraycopy(datas, 0, buff, 0, num);
            startTime = System.nanoTime();
            RandomQuickSort randomQuickSort = new RandomQuickSort(buff);
            endTime = System.nanoTime();
            times[3][i] = (endTime - startTime) * 1.0 / 1000000;

            System.arraycopy(datas, 0, buff, 0, num);
            startTime = System.nanoTime();
            ThreeWayPartitionQuickSort threeWayPartitionQuickSort = new ThreeWayPartitionQuickSort(buff);
            endTime = System.nanoTime();
            times[4][i] = (endTime - startTime) * 1.0 / 1000000;
        }

        for (int i = 0; i < 5; i++) {
            aveTimes[i] = StdStats.mean(times[i]);
        }
    }

    private void randomData(int[] datas, int num, int choice) {
        if (choice == 1) {
            Random r = new Random();
            for (int i = 0; i < num; i++) {
                datas[i] = r.nextInt(100000);
            }
        } else if (choice == 2) {
            for (int i = 0; i < num; i++) {
                datas[i] = i;
            }
        }   else if (choice == 3) {
            for (int i = 0; i < num; i++) {
                datas[i] = num - i;
            }
        }   else {
            throw new IllegalArgumentException("非法参数");
        }
    }

    private static void show(int i) {
        System.out.println("--------------------------------------------------------");
        if(i == 0) {
            System.out.println("插入排序:");
            showTime(i);
        } else if (i == 1) {
                System.out.println("自顶向下归并排序:");
                showTime(i);
        } else if (i == 2) {
            System.out.println("自底向上归并排序:");
            showTime(i);
        } else if (i == 3) {
            System.out.println("随机快速排序:");
            showTime(i);
        } else if (i == 4) {
            System.out.println("Dijkstra 3-路划分快速排序:");
            showTime(i);
        }

    }

    private static void showTime(int i) {
        for(int j = 0; j < 10; j++) {
            System.out.print(times[i][j] + "ms ");
        }
        System.out.println("\n此算法平均消耗时间为：" + aveTimes[i] + "ms");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数据规模:");
        int num = sc.nextInt();
        System.out.print("请选择产生的数据的顺序(1-随机，2-升序，3-降序):");
        int choice = sc.nextInt();
        SortTest sortTest = new SortTest(num, choice);
        for (int i = 0; i < 5; i++) {
            show(i);
        }
    }
}
