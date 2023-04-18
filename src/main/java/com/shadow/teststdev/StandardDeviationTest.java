package com.shadow.teststdev;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import java.util.Random;

/**
 * 样本标准差
 */
public class StandardDeviationTest {

    public static void main(String[] args) {
        StandardDeviation standardDeviation = new StandardDeviation();
        double[] values = new double[5];
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            values[i] =  random.nextInt(1000);
        }
        double evaluate = standardDeviation.evaluate(values);
        System.out.println(evaluate);
    }

}
