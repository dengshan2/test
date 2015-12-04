package com.zd.random;

/**
 * Created by root on 12/4/15.
 * author: zd
 */
public class TestRandom {
    public static void main(String[] args) {
//        Random random1 = new Random(100);
//        System.out.println(random1.nextInt());
//        System.out.println(random1.nextFloat());
//        System.out.println(random1.nextBoolean());
//        Random random2 = new Random(100);
//        System.out.println(random2.nextInt());
//        System.out.println(random2.nextFloat());
//        System.out.println(random2.nextBoolean());
        int i = 0;
        while (i < 100) {
            System.out.print((int) (Math.random() * 9000) + 1000 + ", ");
            i++;
            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}
