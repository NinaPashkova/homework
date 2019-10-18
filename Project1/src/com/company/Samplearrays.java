package com.company;

public class Samplearrays {
    public static void main(String[] args) {
      /* for (int i = args.length-1; i >= 0 ; i--) {
           System.out.println(args[i]);*/
        int a = 1;
        int a1[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] a2 = new int[5];
        int[][] a3 = new int[3][5];
        int[][] a4 = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[][] a5 = {{1, 7, 3},
                {4, 5, 6},
                {7, 4, 9}};
        // System.out.println(Arrays.deepToString(a4));
        System.out.println(new StringBuilder("jjjjjjjhdddppdppd").reverse());// reverse line

        arraysPrint(a4);
        arraysPrint(a5);
        /* int sum1 = 0;

        for (int i = 0; i < a4.length; i++) {
            int sum2 = 0;
            for (int j = 0; j < a4[i].length ; j++) {
                sum1 += a4[i][j] ;
                sum2 += a4[i][j];
                System.out.print(a4[i][j] + "");
            }
            System.out.println(sum2);
        }
        System.out.print(sum1);*/

     /*  System.out.println(a1);
       System.out.println(a1[3]);
       System.out.println(a1[7]);
       System.out.println(Arrays.toString(a1));
       System.out.println(Arrays.toString(a2));
       for (int i = 0; i < a1.length; i++) {
           System.out.println(a1[i]);

       }
       for (int i = 0; i <= a1.length-1; i++) {
           System.out.println(a1[i]);

       }
       for (int i = a1.length - 1; i >= 0; i--) {
           System.out.println();
       }*/
   /*  int sum = 0;
       for (int i : a1) {
           if (i%2 == 0)
               sum+=i;

           System.out.println("i = " + i);
       }
       System.out.println("sum = " + sum);
   }*/


       /* for (int i = 0; i < 50; i++) {
            System.out.println("i = " + i);

        }

        int a = 100;
        do {
            System.out.println("a = " + a);
            a++;
        }

        while (a < 50);



        int b = 0;
        do {
            if ((b % 2) == 0) {

                System.out.println("b = " + b);
            }
            b++;
        }
        while (b < 100);
        int b1 = 0;
        do {
            if ((b1 % 2) != 0) {

                System.out.println("b1 = " + b1);
            }
            b1++;
        }
        while (b1 < 100);*/
       /* for (
                int j = 0;
                j < 100; j++) {
            if ((j % 2) != 0) continue;
            System.out.println("j = " + j);*/





    }

    private static void arraysPrint(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.print(anInt+ " ");
            }
            System.out.println();
        }
    }
}
