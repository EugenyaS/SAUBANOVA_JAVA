package ru.saubanova;

public class Main {

    public static int fib(int n) {
        System.out.println("in fib with n = " + n);
        if (n == 0 || n == 1) {
            return n;
        }
        if (n==2) {
            return fib(n-1)+fib(n-2);
        }
        int tmp = fib(n - 2);
        int result = 2*tmp + fib(n - 3);
        System.out.println("out from fib with result = " + result);
        return result;
    }


    public static void main(String[] args) {
//        System.out.println(fact(5));
        System.out.println(fib(10));
    }
}
