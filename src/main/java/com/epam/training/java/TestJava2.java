package com.epam.training.java;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestJava2 {

    static int method() {
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
            try {
                if (i == 1) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Exception!");
                // return i;
            } finally {
                System.out.println("Finally block");
            }
        }
        return -1;
    }

    public int summ(int a, int b) {
        try {
            return a + b;
        } finally {
            if (a == b)
                return 0;
        }
    }

    public static void main(String[] args)  {
        int i =0;
        int j =0;
        j = i++;
        System.out.print(i);
        System.out.println(j);

        System.out.println("" + new TestJava2().summ(3, 4));

//        System.out.println("method() returned " + method());
       /* label:
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (i > 2) break label;
                System.out.print(j);
            }
            System.out.print(" ");
        }*/
     /*   int i = 0;
        System.out.println(i + '0');
        int[] c = {3, 5};
        for (long x : c) {
            System.out.println(x);

        }
        int[] i1[] = {{1}, {2}};
        int[][] i2 = {{1}, {2}};
        System.out.println(i1 + "" + i2);*/

    }
}


class A {
    public void method() throws IOException {}
}

class B extends A {
    public void method() throws FileNotFoundException {}
}


