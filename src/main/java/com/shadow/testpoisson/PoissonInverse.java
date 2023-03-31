package com.shadow.testpoisson;

import org.apache.commons.math3.distribution.PoissonDistribution;

public class PoissonInverse {

    public static void main(String[] args) {
        double lambda = 411.5; // Poisson分布的参数
        double p = 0.95; // 要求的分位数概率值
        PoissonDistribution poisson = new PoissonDistribution(lambda);
        double x = poisson.inverseCumulativeProbability(p);
        System.out.println("The Poisson inverse function of p=" + p + " with lambda=" + lambda + " is " + x);

        double v = poisson.cumulativeProbability(445);
        System.out.println(v);

    }
}
