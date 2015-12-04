package com.zd.sort.bubble;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by root on 11/30/15.
 * author: zd
 */
public class BubbleSort {
    private static Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int length = array.length;

    public static void main(String[] args) {
        shuffle();
        print();
//        bubbleSort1();
//        bubbleSort2();
        bubbleSort3();
        print();
    }

    public static void print() {
        for (int i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void shuffle() {
        List<Integer> list = Arrays.asList(array);
        Collections.shuffle(list);
    }

    /* 冒泡排序1 */
    public static void bubbleSort1() {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 1; j < length - i; j++) {
                if (array[j-1] > array[j]) {
                    swap(j-1, j);
                }
            }
        }
    }

    /* 冒泡排序2 */
    public static void bubbleSort2() {
        int k = length;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int j = 1; j < k; j++) {
                if (array[j-1] > array[j]) {
                    flag = true;
                    swap(j-1, j);
                }
            }
            k--;
        }
    }

    /* 冒泡排序3 */
    public static void bubbleSort3() {
        int flag = length, k;
        while (flag > 0) {
            k = flag;
            flag = 0;
            for (int j = 1; j < k; j++) {
                if (array[j-1] > array[j]) {
                    swap(j-1, j);
                    flag = j;
                }
            }
        }
           }

    private static void swap(int m, int n) {
        int tmp = array[m];
        array[m] = array[n];
        array[n] = tmp;
    }
}
