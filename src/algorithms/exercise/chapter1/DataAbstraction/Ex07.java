package algorithms.exercise.chapter1.DataAbstraction;

import algorithms.source.chapter1.FundamentalsModel.StdOut;

/**
 * 1.1.7
 *
 * @author gongxun
 * @create 2018-02-08 23:13
 **/
public class Ex07 {

    public static void main(String[] args) {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2.0;
        }
        StdOut.printf("%.5f\n", t);

        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        StdOut.println(sum);

        int total = 0;
        for (int i = 1; i < 1000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                total++;
            }
        }
        StdOut.println(total);
    }
}
