package ru.saubanova;

import java.util.Scanner;

class CalculateOfIntegral {
    public static double f(double x) {
        return x * x;
    }

    public static double integralByRectangles(double a, double b, int n) {
        double delta = (b - a) / n;
        double result = 0;
        for (int i = 1; i <= n; i++) {
            result = result + f(a +delta *( i  - 0.5));
        }
        return delta * result;
    }

    public static double integralBySimpson(double a, double b, int n) {
        double delta = (b - a) / n;
        double result = 0;
        for (int i = 1; i <= n; i += 2) {
            result = result + f(a + (i - 1) * delta) + 4 * f(a + i * delta) + f(a + (i + 1) * delta);
        }
        return delta / 3 * result;
    }

    public static double integralByTrapeze(double a, double b, int n) {
        double delta = (b - a) / n;
        double result = 0;
        for (int i = 1; i < n; i ++) {
            result = result + f(a + i * delta) ;
        }
        return delta * ((f(a) + f(b)) / 2 + result);
    }


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        int n = scanner.nextInt();
        System.out.println(integralByRectangles(a, b, n));
        System.out.println(integralBySimpson(a, b, n));
        System.out.println(integralByTrapeze(a, b, n));
    }
}
