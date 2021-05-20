package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//add a new annotation
//		int[] arry = {5,6,2,3,9,7,1};
        int[] arry = {12,2,16,30,8,28,4,10,20,6,18};
        HeapSort heap = new HeapSort();
        heap.setHeap(arry);
        System.out.println(Arrays.toString(heap.ascOrder()));
        int[] arry1 = {8,4,6,32,54,2,51};
        heap.setHeap(arry1);
        System.out.println(Arrays.toString(heap.desOrder()));

        System.out.println(Math.sqrt(784));
        System.out.println();

        int N = 5;
        int V = 36;
        int [] v = new int [N+1];
        int [] w = new int [N+1];
        v[0] = 45;
        v[1] = 28;
        v[2] = 91;
        v[3] = 20;
        v[4] = 10;

        w[0] = 15;
        w[1] = 10;
        w[2] = 30;
        w[3] = 8;
        w[4] = 7;

        int val[] = new int[] { 45, 28, 91, 20, 10 };
        int wt[] = new int[] { 15, 10, 30, 8, 7 };
        int W = 36;
        int n = val.length;
        System.out.println(Knapsack.knapSack(W, wt, val, n));
    }
}
