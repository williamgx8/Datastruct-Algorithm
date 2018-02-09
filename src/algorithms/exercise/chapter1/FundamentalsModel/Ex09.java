package algorithms.exercise.chapter1.FundamentalsModel;

import algorithms.source.chapter1.FundamentalsModel.StdIn;
import algorithms.source.chapter1.FundamentalsModel.StdOut;

/**
 * 编写一段代码，将一个正整数N用二进制表示并转换为一个String类型的s
 *
 * @author gongxun
 * @create 2018-02-09 22:34
 **/
public class Ex09 {
    public static void main(String[] args) {
        String result = "";
        int num = StdIn.readInt();
        while (num != 0) {
            result = num % 2 + result;
            num /= 2;
        }
        StdOut.println(result);
    }
}
