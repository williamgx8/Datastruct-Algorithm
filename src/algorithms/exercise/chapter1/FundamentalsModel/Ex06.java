package algorithms.exercise.chapter1.FundamentalsModel;

import algorithms.source.chapter1.FundamentalsModel.StdOut;

/**
 * 1.1.6
 *
 * @author gongxun
 * @create 2018-02-08 22:58
 **/
public class Ex06 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <=15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }

    }
}
