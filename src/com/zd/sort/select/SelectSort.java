package com.zd.sort.select;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by root on 12/3/15.
 * author: zd
 */
public class SelectSort {
    private static Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int length = array.length;

    public static void main(String[] args) {
        shuffle();
        print();
        selectSort();
        print();
    }

    /* 选择排序 */
    public static void selectSort() {
        int i, j, nMinIndex;
        for (i = 0; i < length; i++) {
            nMinIndex = i;
            for (j = i + 1; j < length; j++) {
                if (array[j] < array[nMinIndex]) {
                    nMinIndex = j;
                }
            }
            swap(i, nMinIndex);
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
