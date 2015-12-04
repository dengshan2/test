package com.zd.sort.insert;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by root on 12/2/15.
 * author: zd
 */
public class InsertSort {
    private static Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int length = array.length;

    public static void main(String[] args) {
        shuffle();
        print();
//        insertSort1();
//        insertSort2();
        insertSort3();
        print();
    }

    /* 插入排序3 */
    public static void insertSort3() {
        int i, j;
        for (i = 1; i < length; i++) {
            for (j = i - 1; j >= 0 && array[j] > array[j+1]; j--) {
                swap(j, j+1);
            }
        }
    }

    /* 插入排序2 */
    public static void insertSort2() {
        int i, j;
        for (i = 1; i < length; i++) {
            if (array[i-1] > array[i]) {
                int tmp = array[i];
                for (j = i - 1; j >= 0 && array[j] > tmp; j--) {
                    array[j+1] = array[j];
                }
                array[j+1] = tmp;
            }
        }
    }

    /* 插入排序1 */
    public static void insertSort1() {
        int j;
        for (int i = 1; i < length; i++) {
            for (j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    break;
                }
            }
            if (j != i-1) {
                int tmp = array[i];
                System.arraycopy(array, j + 1, array, j + 1 + 1, i - 1 - j);
                array[j+1] = tmp;
            }
        }
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

    private static void swap(int m, int n) {
        int tmp = array[m];
        array[m] = array[n];
        array[n] = tmp;
    }
}
