package com.zd.sort.merger;

/**
 * Created by root on 12/4/15.
 * author:　zd
 */
public class MergerSort {
    private static int[] array1 = new int[]{1, 2, 4, 6, 8};
    private static int[] array2 = new int[]{3, 5, 7, 9, 10};
    private static int[] array;
    private static int[] temp;
    private static int length1 = array1.length;
    private static int length2 = array2.length;
    private static int length;

    public static void main(String[] args) {
        init();
        print();
        mergerSort(0, length-1);
        print();
    }

    public static void mergerArray(int first, int mid, int last) {
        int i = first;
        int j = mid + 1;
        int m = mid;
        int n = last;
        int k = 0;
        while (i <= m && j <= n) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= m) {
            temp[k++] = array[i++];
        }
        while (j <= n) {
            temp[k++] = array[j++];
        }
        System.arraycopy(temp, 0, array, first, last-first+1);
    }

    public static void mergerSort(int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergerSort(first, mid);
            mergerSort(mid+1, last);
            mergerArray(first, mid, last);
        }
    }

    public static void mergerSort1() {
        int i, j, k;
        i = j = k = 0;
        while (i < length1 && j < length2) {
            if (array1[i] < array2[j]) {
                array[k++] = array1[i++];
            } else {
                array[k++] = array2[j++];
            }
        }
        while (i < length1) {
            array[k++] = array1[i++];
        }
        while (j < length2) {
            array[k++] = array2[j++];
        }
    }





    public static void print() {
        int i = 0;
        while (i < length - 1) {
            System.out.print(array[i] + ", ");
            i++;
        }
        System.out.println(array[i]);
    }

    public static void init() {
        length = length1 + length2;
        array = new int[length];
        temp = new int[length];
//        System.arraycopy(array1, 0, array, 0, length1);
//        System.arraycopy(array2, 0, array, length1, length2);
        int i = 0;
        while (i < 10) {
            array[i++] = (int)(Math.random()*10000);
        }
    }
}
