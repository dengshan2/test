package com.zd.sort.shell;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by root on 12/3/15.
 * author: zd
 */
public class ShellSort {
    private static Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static int length = array.length;

    public static void main(String[] args) {
        shuffle();
        print();
//        shellSort1();
//        shellSort2();
        shellSort3();
        print();
    }

    /* 希尔排序 */
    public static void shellSort1() {
        int i, j, gap;
        for (gap = length/2; gap > 0; gap /= 2) {
            for (i = 0; i < gap; i++) {
                for (j = i + gap; j < length; j++) {
                    if (array[j] < array[j-gap]) {
                        int tmp = array[j];
                        int k = j - gap;
                        while (k >= 0 && array[k] > tmp) {
                            array[k+gap] = array[k];
                            k -= gap;
                        }
                        array[k+gap] = tmp;
                    }
                }
            }
        }
    }

    /* 希尔排序2 */
    public static void shellSort2() {
        int i, gap;
        for (gap = length/2; gap > 0; gap /=2) {
            for (i = gap; i < length; i++) {
                if (array[i] < array[i-gap]) {
                    int tmp = array[i];
                    int k = i - gap;
                    while (k >= 0 && array[k] > tmp) {
                        array[k+gap] = array[k];
                        k -= gap;
                    }
                    array[k+gap] = tmp;
                }
            }
        }
    }

    public static void shellSort3() {
        int i, gap;
        for (gap = length/2; gap > 0; gap /= 2) {
            for (i = gap; i < length; i++) {
                if (array[i] < array[i-gap]) {
                    for (int j = i - gap; j >= 0 && array[j] > array[j+gap]; j-=gap) {
                        swap(j, j+gap);
                    }
                }
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
