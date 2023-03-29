package com.shadow.testpoisson;

/**
 * @author
 */
public class PoissonTest {

    public static void main(String[] args) {
        double v = poissonDistribution(26, 21.1);
        System.out.println(v);

        int i = inversePoisson(0.85, 21.1);
        System.out.println(i);

    }

    public static int inversePoisson(double p, double lambda) {
        int left = 0;
        int right = 10000;
        while (left <= right) {
            int mid = (left + right) / 2;
            double f = poissonDistribution(mid, lambda);
            if (f >= p) {
                return mid;
            } else {

                right = mid - 1;
                left = mid + 1;
            }
        }
        return -1; // 如果没有找到符合条件的x，返回-1
    }

    public static double poissonDistribution(int x, double lambda) {
        double sum = 0;
        double e = Math.exp(-lambda);
        for (int k = 0; k <= x; k++) {
            double numerator = Math.pow(lambda, k) * e;
            double denominator = factorial(k);
            sum += numerator / denominator;
        }
        return sum;
    }

    public static double factorial(int n) {
        double result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
