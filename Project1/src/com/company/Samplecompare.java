package com.company;

public class Samplecompare {
      public static void main(String[] args) {
           System.out.println("Hi" == "Hi");
           String a = "Hi";
           String b = "Hi";
           System.out.println(a == b);
           String a1 = new String("Hi");
           String b2 = "Hi";
           System.out.println(a1 == b2);
           System.out.println(a1.equals(b2));
           System.out.println("Hi"+"Hi");
           int c = 100;
           System.out.println("Hi -"+c);
           System.out.println(""+c); // пустая строка + чтото равно строка
           System.out.println("100"+c);
           System.out.println("4/2="+4/2 == "4/2=2");


       }
  /*public static void main(String[] args) {
           char c1 = '1';
           char c2 = '\u0031';
           char c3 = 49;
           System.out.println(c1+c2+c3);
           System.out.println(c1);
           System.out.println(c2);
           System.out.println(c3);
       }*/
     /*  public static void main(String[] args) {
           System.out.println(" 100 ml ".trim().split("\\s+")[1]);
           System.out.println(Arrays.toString("gggggjjureed".trim().split("")));
           System.out.println("ggdgjjurdeed".trim().split("d").length);
       }*/


    /*public static void main(String[] args) {
        byte b1 =50, b2 = 99;
        byte k = (byte) (b1 + b2);
        System.out.println("k="+ k);
    }
    */
}
